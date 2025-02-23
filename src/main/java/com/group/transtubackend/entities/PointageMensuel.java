package com.group.transtubackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class PointageMensuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    private int heure_ferie;
    private int heure_normale;
    private int heure_nuit;
    private int heure_25;
    private int heure_50;
    private int anne;
    private int mois;
    private int jour;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public PointageMensuel(int heure_ferie, int heure_normale, int heure_nuit, int heure_25, int heure_50, int anne, int mois, int jour) {
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
