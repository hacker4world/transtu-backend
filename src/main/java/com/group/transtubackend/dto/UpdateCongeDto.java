package com.group.transtubackend.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UpdateCongeDto {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
}
