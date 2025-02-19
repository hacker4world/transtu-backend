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
public class Pointage_hebdomadaire {
    @Id
    private String matricule;
    private int heure_ferie;
    private int heure_normale;
    private int heure_nuit;
    private int heure_25;
    private int heure_50;
    private int anne;
    private int mois;
    private int jour;

    public Pointage_hebdomadaire(String matricule, int heure_ferie, int heure_normale, int heure_nuit, int heure_25, int heure_50, int anne, int mois, int jour) {
        this.matricule = matricule;
        this.heure_ferie = heure_ferie;
        this.heure_normale = heure_normale;
        this.heure_nuit = heure_nuit;
        this.heure_25 = heure_25;
        this.heure_50 = heure_50;
        this.anne = anne;
        this.mois = mois;
        this.jour = jour;
    }
}
