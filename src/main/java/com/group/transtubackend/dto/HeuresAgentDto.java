package com.group.transtubackend.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class HeuresAgentDto {
    private int agentId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
}
