package com.group.transtubackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Builder
public class HeuresAgentResponse {
    private int heures_jour;
    private int heures_nuit;
    private int jours_absences;
    private long jours_defaillances;
    private long jours_conges;
    private String agentName;
}
