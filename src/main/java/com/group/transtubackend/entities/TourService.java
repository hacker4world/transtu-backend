package com.group.transtubackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TourService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code_service;
    private int anne;
    private int mois;
    private int jour;
    private String type_bareme; //sif, chtee, romthan;
    private String numero_tour_service;
    private String travail_assure; //continue walle
    private String code_jour_bareme; //na3rech
    private int heure_jour;
    private int heure_nuit;
    private String panier;
    private String code_etat_enregistrement;

    @ManyToOne
    @JoinColumn(name = "matricule_chauffeur")
    private Agent chauffeur;

    @ManyToOne
    @JoinColumn(name = "matricule_receveur")
    private Agent receveur;

    public TourService(int anne, int mois, int jour, String type_bareme, String numero_tour_service, String travail_assure, String code_jour_bareme, int heure_jour, int heure_nuit, String panier, String code_etat_enregistrement) {
        this.anne = anne;
        this.mois = mois;
        this.jour = jour;
        this.type_bareme = type_bareme;
        this.numero_tour_service = numero_tour_service;
        this.travail_assure = travail_assure;
        this.code_jour_bareme = code_jour_bareme;
        this.heure_jour = heure_jour;
        this.heure_nuit = heure_nuit;
        this.panier = panier;
        this.code_etat_enregistrement = code_etat_enregistrement;
    }
}
