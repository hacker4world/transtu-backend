package com.group.transtubackend.authentication;

import com.group.transtubackend.authentication.dto.ApiResponse;
import com.group.transtubackend.authentication.dto.LoginDto;
import com.group.transtubackend.authentication.dto.LoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> login(@RequestBody LoginDto loginDto) {
        return authenticationService.login(loginDto);
    }

}
