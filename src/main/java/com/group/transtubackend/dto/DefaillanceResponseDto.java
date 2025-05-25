package com.group.transtubackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Builder
@Data
public class DefaillanceResponseDto {
    private int id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String agentNom;
    private String agentPrenom;
}
