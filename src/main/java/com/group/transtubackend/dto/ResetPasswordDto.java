package com.group.transtubackend.dto;

import lombok.Getter;

@Getter
public class ResetPasswordDto {
    private String email;
    private String newPassword;
    private String resetCode;


}
