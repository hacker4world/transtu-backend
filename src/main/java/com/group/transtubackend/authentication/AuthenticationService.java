package com.group.transtubackend.authentication;

import com.group.transtubackend.authentication.dto.ApiResponse;
import com.group.transtubackend.authentication.dto.LoginDto;
import com.group.transtubackend.authentication.dto.LoginResponseDto;
import com.group.transtubackend.authentication.entities.User;
import com.group.transtubackend.authentication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    @Autowired
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<ApiResponse<LoginResponseDto>> login(LoginDto loginDto) {
        Optional<User> user = userRepository.findByEmail(loginDto.getEmail());
        if (user.isEmpty()) {
            return ResponseEntity
                    .status(403)
                    .body(ApiResponse.<LoginResponseDto>builder().message("Invalid email or password").build());
        }

        User userEntity = user.get();

        if (!userEntity.getPassword().equals(loginDto.getPassword())) {
            return ResponseEntity
                    .status(403)
                    .body(ApiResponse.<LoginResponseDto>builder().message("Invalid email or password").build());
        }

        return ResponseEntity.ok(ApiResponse.<LoginResponseDto>builder()
                .data(LoginResponseDto.builder()
                        .firstName(userEntity.getFirstName())
                        .lastName(userEntity.getLastName())
                        .email(userEntity.getEmail())
                        .role(userEntity.getRole())
                        .departmentName(userEntity.getDepartement().getName())
                        .departmentId(userEntity.getDepartement().getId())
                        .build()
                )
                .build()
        );
    }

}
