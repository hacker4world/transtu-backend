package com.group.transtubackend.dto;

import lombok.Getter;

@Getter
public class MarkAgentLateDto {
    private int agentId;

    private int day;
    private int month;
    private int year;

    private int hours;
    private int minutes;
}
