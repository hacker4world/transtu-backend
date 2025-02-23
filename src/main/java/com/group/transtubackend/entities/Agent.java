package com.group.transtubackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    private String nom;
    private String prenom;
    private Date date_naiss;
    private String situation_familiale;
    private String code_emploi_assure;
    private String code_grade;
    private String code_service;

    public Agent(String nom, String prenom, Date date_naiss, String situation_familiale, String code_emploi_assure, String code_grade, String code_service) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.situation_familiale = situation_familiale;
        this.code_emploi_assure = code_emploi_assure;
        this.code_grade = code_grade;
        this.code_service = code_service;
    }
}
