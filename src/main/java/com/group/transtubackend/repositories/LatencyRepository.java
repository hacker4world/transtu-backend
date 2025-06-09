package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.Absence;
import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.Latency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LatencyRepository extends JpaRepository<Latency, Long> {
    List<Latency> findByAgentAndDayAndMonthAndYear(Agent agent, int day, int month, int year);

    List<Latency> findByAgent(Agent agent);
}
