package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.ListeTours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TourServiceRepository extends JpaRepository<ListeTours, Integer> {
    Optional<ListeTours> findByChauffeur(Agent chauffeur);

    List<ListeTours> findByDate(LocalDate date);

    Optional<ListeTours> findByReceveur(Agent receveur);
}
