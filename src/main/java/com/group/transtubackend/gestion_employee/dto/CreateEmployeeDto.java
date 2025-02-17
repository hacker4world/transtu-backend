package com.group.transtubackend.gestion_employee.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateEmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private int departementId;
}
