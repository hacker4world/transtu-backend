package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.District;
import com.group.transtubackend.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);
    void deleteByEmail(String email);
}
