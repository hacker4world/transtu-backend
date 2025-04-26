package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<District, Integer> {
}
