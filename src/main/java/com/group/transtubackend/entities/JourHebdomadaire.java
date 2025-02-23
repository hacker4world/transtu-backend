package com.group.transtubackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class JourHebdomadaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    private String code_jour;
    private int anne_debut_repos;
    private int mois_debut_repos;
    private int jour_debut_repos;
    private int anne_fin_repos;
    private int mois_fin_repos;
    private int jour_fin_repos;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public JourHebdomadaire(String code_jour, int anne_debut_repos, int mois_debut_repos, int jour_debut_repos, int anne_fin_repos, int mois_fin_repos, int jour_fin_repos) {
        this.code_jour = code_jour;
        this.anne_debut_repos = anne_debut_repos;
        this.mois_debut_repos = mois_debut_repos;
        this.jour_debut_repos = jour_debut_repos;
        this.anne_fin_repos = anne_fin_repos;
        this.mois_fin_repos = mois_fin_repos;
        this.jour_fin_repos = jour_fin_repos;
    }
}
