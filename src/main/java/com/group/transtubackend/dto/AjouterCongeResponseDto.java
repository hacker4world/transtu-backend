package com.group.transtubackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class AjouterCongeResponseDto {
    private int id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int nbrJours;
    private String agentName;
    private int agentId;
}
