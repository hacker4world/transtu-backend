package com.group.transtubackend.authentication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bareme_tour_service {
    @Id
    private int id;
    private int anne;
    private int mois;
    private int jour;
    private String type_bareme;
    private String code_service;
    private String numero_tour_service;
    private String travail_assure;
    private String code_jour_bareme;
    private int heure_jour;
    private int heure_nuit;
    private String panier;
    private String code_etat_enregistrement;

    public Bareme_tour_service(int anne, int mois, int jour, String type_bareme, String code_service, String numero_tour_service, String travail_assure, String code_jour_bareme, int heure_jour, int heure_nuit, String panier, String code_etat_enregistrement) {
        this.anne = anne;
        this.mois = mois;
        this.jour = jour;
        this.type_bareme = type_bareme;
        this.code_service = code_service;
        this.numero_tour_service = numero_tour_service;
        this.travail_assure = travail_assure;
        this.code_jour_bareme = code_jour_bareme;
        this.heure_jour = heure_jour;
        this.heure_nuit = heure_nuit;
        this.panier = panier;
        this.code_etat_enregistrement = code_etat_enregistrement;
    }
}
