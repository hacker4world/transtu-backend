package com.group.transtubackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int nbr_jour;
    private String code_conge;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public Conge(LocalDate dateDebut, LocalDate dateFin, int nbr_jour, String code_conge, Agent agent) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbr_jour = nbr_jour;
        this.code_conge = code_conge;
        this.agent = agent;
    }
}
