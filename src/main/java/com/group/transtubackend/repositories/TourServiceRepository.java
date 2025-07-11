package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.District;
import com.group.transtubackend.entities.TourService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourServiceRepository extends JpaRepository<TourService, Long> {
    List<TourService> findAllByDayAndMonthAndYear(int day, int month, int year);

    @Query("SELECT s FROM TourService s WHERE s.driver = :employee OR s.receiver = :employee")
    List<TourService> findByAgent(Agent employee);

    List<TourService> findAllByDayAndMonthAndYearAndTourDistrict(int day, int month, int year, District district);
}
