package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {
    List<Agent> findByRole(String role);

    @Query("SELECT a FROM Agent a WHERE a.matricule NOT IN " +
            "(SELECT DISTINCT d.agent.matricule FROM Defaillance d WHERE :targetDate BETWEEN d.dateDebut AND d.dateFin) " +
            "AND a.matricule NOT IN " +
            "(SELECT DISTINCT c.agent.matricule FROM Conge c WHERE :targetDate BETWEEN c.dateDebut AND c.dateFin)")
    List<Agent> findAgentsWithNoDefaillanceOrCongeOnDate(@Param("targetDate") LocalDate targetDate);

}