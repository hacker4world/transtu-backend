package com.group.transtubackend.dto;

import lombok.Getter;

@Getter
public class CreateEmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private int departementId;
}
