package com.group.transtubackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String role;
    private String code_reset;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Agent agent;
}
