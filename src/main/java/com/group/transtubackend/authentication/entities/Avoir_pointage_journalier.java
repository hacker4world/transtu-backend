package com.group.transtubackend.authentication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Avoir_pointage_journalier {
    @Id
    private String matricule;
    private int anne;
    private int mois;
    private int jour;
    private int heure_jour;
    private int heure_nuit;
    private int heure_continue;
    private int code_service;
    private int num_service;

    public Avoir_pointage_journalier(String matricule, int anne, int mois, int jour, int heure_jour, int heure_nuit, int heure_continue, int code_service, int num_service) {
        this.matricule = matricule;
        this.anne = anne;
        this.mois = mois;
        this.jour = jour;
        this.heure_jour = heure_jour;
        this.heure_nuit = heure_nuit;
        this.heure_continue = heure_continue;
        this.code_service = code_service;
        this.num_service = num_service;
    }
}
