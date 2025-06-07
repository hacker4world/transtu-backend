package com.group.transtubackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AbsenceResponseDto {
    private Long id;
    private int day;
    private int month;
    private int year;
    private String agentName;
    private int agentId;
}
