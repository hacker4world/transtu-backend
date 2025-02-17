package com.group.transtubackend.authentication.repositories;

import com.group.transtubackend.authentication.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
