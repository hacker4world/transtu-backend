package com.group.transtubackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ListeTours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code_service;
    private int jour;
    private int mois;
    private String saison;
    private boolean travail_assure;
    private boolean travail_continue;
    private int heures_jour;
    private int heures_nuit;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

}
