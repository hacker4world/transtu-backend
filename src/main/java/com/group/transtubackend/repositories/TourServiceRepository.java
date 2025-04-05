package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.TourService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TourServiceRepository extends JpaRepository<TourService, Integer> {
    Optional<TourService> findByChauffeur(Agent chauffeur);

    List<TourService> findByDate(LocalDate date);

    Optional<TourService> findByReceveur(Agent receveur);
}
