package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {
    List<Agent> findByRole(String role);
}