package com.group.transtubackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class DefaillanceResponse {
    private int id;
    private int nombre_jour;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private int nbre_heure;
    private int agentId;
    private String agentNom;
    private String agentPrenom;
}

