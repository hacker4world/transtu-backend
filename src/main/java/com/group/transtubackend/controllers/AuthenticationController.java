package com.group.transtubackend.controllers;


import com.group.transtubackend.dto.*;
import com.group.transtubackend.services.AuthenticationService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody LoginDto loginDto)
    {
        return authenticationService.login(loginDto);
    }

    @PostMapping("send-reset-email")
    public ResponseEntity<ApiResponse<String>> sendResetEmail(@RequestBody SendPasswordResetEmailDto resetPasswordDto) throws MessagingException {
        return authenticationService.resetPassword(resetPasswordDto);
    }

    @PostMapping("reset-password")
    public ResponseEntity<ApiResponse<String>> resetPassword(@RequestBody ChangePasswordDto resetPasswordDto) {
        return authenticationService.changePassword(resetPasswordDto);
    }

}
