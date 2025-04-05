package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.Defaillance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DefaillanceRepository extends JpaRepository<Defaillance, Long> {

}
