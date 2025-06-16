package com.group.transtubackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    private String nom;
    private String prenom;
    private Date date_naiss;
    private String situation_familiale;
    private String role;

    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    @JsonBackReference
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "code_departement")
    @JsonIgnore
    private District district;

    @JsonIgnore
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Defaillance> defaillances;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Conge> conges;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Absence> absences;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Latency> latencies;

    public Agent(String nom, String prenom, Date date_naiss, String situation_familiale, String role, District district, Utilisateur utilisateur) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.situation_familiale = situation_familiale;
        this.role = role;
        this.district = district;
        this.utilisateur = utilisateur;
    }
}
