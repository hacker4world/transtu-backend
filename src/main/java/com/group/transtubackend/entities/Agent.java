package com.group.transtubackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    private String nom;
    private String prenom;
    private Date date_naiss;
    private String situation_familiale;
    private String code_emploi_assure;
    private String code_grade;
    private String role;    

    @ManyToOne
    @JoinColumn(name = "code_departement")
    private Departement departement;

    @OneToMany(mappedBy = "agent")
    private List<PointageJournalier> pointageJournaliers;

    @OneToMany(mappedBy = "agent")
    private List<Defaillance> defaillances;

    @OneToMany(mappedBy = "agent")
    private List<Conge> conges;

    public Agent(String nom, String prenom, Date date_naiss, String situation_familiale, String code_emploi_assure, String code_grade, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.situation_familiale = situation_familiale;
        this.code_emploi_assure = code_emploi_assure;
        this.code_grade = code_grade;
        this.role = role;
    }
}
