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
public class TourService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code_service;
    LocalDate date;
    private String type_bareme; //sif, chtee, romthan;
    private String travail_assure; //continue walle
    private String code_jour_bareme; //na3rech
    private String panier;
    private String code_etat_enregistrement;

    @ManyToOne
    @JoinColumn(name = "matricule_chauffeur")
    private Agent chauffeur;

    @ManyToOne
    @JoinColumn(name = "matricule_receveur")
    private Agent receveur;

    @ManyToOne
    @JoinColumn(name = "code_ligne")
    private Ligne ligne;
}
