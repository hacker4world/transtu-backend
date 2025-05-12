package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {
    List<Agent> findByDistrict(District district);
    List<Agent> findByDistrictAndRole(District district, String role);
}