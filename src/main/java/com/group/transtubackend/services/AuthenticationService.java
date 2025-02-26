package com.group.transtubackend.services;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.LoginDto;
import com.group.transtubackend.dto.LoginResponseDto;
import com.group.transtubackend.dto.SendPasswordResetEmailDto;
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

    public ResponseEntity<String> login(LoginDto loginDto) {
        Optional<Utilisateur> userOptional = userRepository.findByEmail(loginDto.getEmail());

        if (userOptional.isEmpty()) return ResponseEntity.status(403).body("Email or password incorrect");

        Utilisateur user = userOptional.get();

        if (!user.getPassword().equals(loginDto.getPassword())) return ResponseEntity.status(403).body("Email or password incorrect");

        return ResponseEntity.status(200).body("User logged in");

    }

    public ResponseEntity<String> resetPassword(SendPasswordResetEmailDto resetData) throws MessagingException {
        Optional<Utilisateur> userOptional = userRepository.findByEmail(resetData.getEmail());

        if (userOptional.isEmpty()) return ResponseEntity.status(404).body("Email incorrect");

        Utilisateur user = userOptional.get();

        String code = String.valueOf(generateFiveDigitRandomNumber());

        user.setCode_reset(code);

        userRepository.save(user);

        emailService.sendPasswordResetEmail(resetData.getEmail(), code);

        return ResponseEntity.status(200).body("Password reset email has been sent");
    }

    private static int generateFiveDigitRandomNumber() {
        Random random = new Random();
        return 10000 + random.nextInt(90000);
    }

}
