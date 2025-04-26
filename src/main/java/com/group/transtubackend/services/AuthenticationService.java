package com.group.transtubackend.services;

import com.group.transtubackend.dto.*;
import com.group.transtubackend.entities.Utilisateur;
import com.group.transtubackend.repositories.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AuthenticationService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    public ResponseEntity<ApiResponse<?>> login(LoginDto loginDto) {
        Optional<Utilisateur> userOptional = userRepository.findByEmail(loginDto.getEmail());

        if (userOptional.isEmpty()) {

            return ResponseEntity.status(403)
                    .body(ApiResponse.<String>builder()
                            .message("Email or password incorrect")
                            .build());
        }

        Utilisateur user = userOptional.get();

        if (!user.getPassword().equals(loginDto.getPassword())) {
            return ResponseEntity.status(403)
                    .body(ApiResponse.<String>builder()
                            .message("Email or password incorrect")
                            .build());
        }

        return ResponseEntity.status(200)
                .body(ApiResponse.<LoginResponseDto>builder()
                        .message("User logged in")
                        .data(LoginResponseDto.builder()
                                .id(user.getMatricule())
                                .firstName(user.getNom())
                                .lastName(user.getPrenom())
                                .email(user.getEmail())
                                .role(user.getRole())
                                .departmentName(user.getDistrict().getName())
                                .departmentId(user.getDistrict().getId())
                                .build())
                        .build());
    }

    public ResponseEntity<ApiResponse<String>> resetPassword(SendPasswordResetEmailDto resetData) throws MessagingException {
        Optional<Utilisateur> userOptional = userRepository.findByEmail(resetData.getEmail());

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(404)
                    .body(ApiResponse.<String>builder()
                            .message("Email incorrect")
                            .build());
        }

        Utilisateur user = userOptional.get();
        String code = String.valueOf(generateFiveDigitRandomNumber());
        user.setCode_reset(code);
        userRepository.save(user);

        emailService.sendPasswordResetEmail(user.getNom(), user.getPrenom(), user.getEmail(), code);

        return ResponseEntity.status(200)
                .body(ApiResponse.<String>builder()
                        .message("Password reset email has been sent")
                        .build());
    }

    public ResponseEntity<ApiResponse<String>> changePassword(ChangePasswordDto changePasswordDto) {
        Optional<Utilisateur> userOptional = userRepository.findByEmail(changePasswordDto.getEmail());

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(404)
                    .body(ApiResponse.<String>builder()
                            .message("Account not found")
                            .build());
        }

        Utilisateur user = userOptional.get();

        if (!user.getCode_reset().equals(changePasswordDto.getCode())) {
            return ResponseEntity.status(403)
                    .body(ApiResponse.<String>builder()
                            .message("Code incorrect")
                            .build());
        }

        user.setPassword(changePasswordDto.getNewPassword());
        userRepository.save(user);

        return ResponseEntity.status(200)
                .body(ApiResponse.<String>builder()
                        .message("Password changed successfully")
                        .build());
    }
    private static int generateFiveDigitRandomNumber() {
        Random random = new Random();
        return 10000 + random.nextInt(90000);
    }

}
