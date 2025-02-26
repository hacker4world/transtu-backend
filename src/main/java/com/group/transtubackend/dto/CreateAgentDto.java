package com.group.transtubackend.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class CreateAgentDto {
    private String nom;
    private String prenom;
    private Date date_naiss;
    private String situation_familiale;
    private String code_emploi_assure;
    private String code_grade;
    private String role;
}
