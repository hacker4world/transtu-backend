package com.group.transtubackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ligne {
    @Id
    private int id;
    private String nom;
    private int heures_jour;
    private int heures_nuit;

}
