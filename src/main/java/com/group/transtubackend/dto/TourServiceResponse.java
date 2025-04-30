package com.group.transtubackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TourServiceResponse {
    private String driver;
    private String receiver;
    private int heuresJour;
    private int heuresNuit;
    private String saison;
    private int day;
    private int dayCode;
    private int month;
    private int year;
}
