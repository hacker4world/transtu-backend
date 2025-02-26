package com.group.transtubackend.dto;

import lombok.Getter;

@Getter
public class ChangePasswordDto {
    private String email;
    private String code;
    private String newPassword;
}
