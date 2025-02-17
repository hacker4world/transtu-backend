package com.group.transtubackend.authentication.repositories;

import com.group.transtubackend.authentication.entities.Departement;
import com.group.transtubackend.authentication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    List<User> findAllByDepartement(Departement departement);
}
