package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.Absence;
import com.group.transtubackend.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findByAgentAndDayAndMonthAndYear(Agent agent, int day, int month, int year);
}
