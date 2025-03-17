package com.group.transtubackend.dto;

import lombok.Getter;

@Getter
public class TourServiceDto {
    private int anne;
    private int mois;
    private int jour;
    private String type_bareme;
    private String numero_tour_service;
    private String travail_assure;
    private String code_jour_bareme;
    private int heure_jour;
    private int heure_nuit;
    private String panier;
    private String code_etat_enregistrement;

}
