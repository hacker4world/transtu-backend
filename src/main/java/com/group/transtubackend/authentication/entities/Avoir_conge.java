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
public class Avoir_conge {
    @Id
    private String matricule;
    private int anne_debut;
    private int mois_debut;
    private int jour_debut;
    private int anne_fin;
    private int mois_fin;
    private int jour_fin;
    private int nbr_jour;
    private String code_conge;

    public Avoir_conge(String matricule, int anne_debut, int mois_debut, int jour_debut, int anne_fin, int mois_fin, int jour_fin, int nbr_jour, String code_conge) {
        this.matricule = matricule;
        this.anne_debut = anne_debut;
        this.mois_debut = mois_debut;
        this.jour_debut = jour_debut;
        this.anne_fin = anne_fin;
        this.mois_fin = mois_fin;
        this.jour_fin = jour_fin;
        this.nbr_jour = nbr_jour;
        this.code_conge = code_conge;
    }
}
