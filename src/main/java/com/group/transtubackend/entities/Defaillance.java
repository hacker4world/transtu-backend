package com.group.transtubackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Defaillance
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    private int nombre_jour;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private int nbre_heure;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public Defaillance(int nombre_jour, LocalDate dateDebut, LocalDate dateFin, LocalTime heureDebut, LocalTime heureFin, int nbre_heure, Agent agent) {
        this.nombre_jour = nombre_jour;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.nbre_heure = nbre_heure;
        this.agent = agent;
    }
}
