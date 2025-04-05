package com.group.transtubackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TourServiceResponse {
    private int code_service;
    LocalDate date;
    private String type_bareme; //sif, chtee, romthan;
    private String travail_assure; //continue walle
    private String code_jour_bareme; //na3rech
    private String panier;
    private String code_etat_enregistrement;
    private int chauffeur;
    private int receveur;
    private int ligne;
}
