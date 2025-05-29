package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.Defaillance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefaillanceRepository extends JpaRepository<Defaillance, Integer> {
    List<Defaillance> findByAgent(Agent agent);
}
