package com.group.transtubackend.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class LoginDto {
    private String email;
    private String password;
}
