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
public class Avoir_defaillance
{
    @Id
    private String matricule;
    private String code_defaillance;
    private int nombre_jour;
    private int anne_debut;
    private int anne_fin;
    private int heure_debut;
    private int heure_fin;
    private String jour_debut;
    private String jour_fin;
    private String mois_debut;
    private String mois_fin;
    private int nbre_heure;

    public Avoir_defaillance(String matricule, String code_defaillance, int nombre_jour, int anne_debut, int anne_fin, int heure_debut, int heure_fin, String jour_debut, String jour_fin, String mois_debut, String mois_fin, int nbre_heure) {
        this.matricule = matricule;
        this.code_defaillance = code_defaillance;
        this.nombre_jour = nombre_jour;
        this.anne_debut = anne_debut;
        this.anne_fin = anne_fin;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.jour_debut = jour_debut;
        this.jour_fin = jour_fin;
        this.mois_debut = mois_debut;
        this.mois_fin = mois_fin;
        this.nbre_heure = nbre_heure;
    }
}
