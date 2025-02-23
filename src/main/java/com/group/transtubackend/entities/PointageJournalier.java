package com.group.transtubackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class PointageJournalier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    private int anne;
    private int mois;
    private int jour;
    private int heure_jour;
    private int heure_nuit;
    private int heure_continue;
    private int code_service;
    private int num_service;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public PointageJournalier(int anne, int mois, int jour, int heure_jour, int heure_nuit, int heure_continue, int code_service, int num_service) {
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
