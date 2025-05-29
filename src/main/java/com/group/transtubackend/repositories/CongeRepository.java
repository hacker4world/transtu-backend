package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Long> {
    List<Conge> findByAgent(Agent agent);
}
