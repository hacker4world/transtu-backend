package com.group.transtubackend.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class DefaillanceDTO {
    private int id;
    private int nombre_jour;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int agentId;
}
