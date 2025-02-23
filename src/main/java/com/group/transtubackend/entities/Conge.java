package com.group.transtubackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    private int anne_debut;
    private int mois_debut;
    private int jour_debut;
    private int anne_fin;
    private int mois_fin;
    private int jour_fin;
    private int nbr_jour;
    private String code_conge;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public Conge(int anne_debut, int mois_debut, int jour_debut, int anne_fin, int mois_fin, int jour_fin, int nbr_jour, String code_conge) {
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
