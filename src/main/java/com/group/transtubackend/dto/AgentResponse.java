package com.group.transtubackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class AgentResponse {
    private int matricule;
    private String nom;
    private String prenom;
    private Date date_naiss;
    private String situation_familiale;
    private String code_emploi_assure;
    private String code_grade;
    private String role;
    private String departement;
}
