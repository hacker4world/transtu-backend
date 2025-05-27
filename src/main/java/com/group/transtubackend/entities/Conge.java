package com.group.transtubackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
