package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.TourService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourServiceRepository extends JpaRepository<TourService, Long> {
    List<TourService> findAllByDayAndMonthAndYear(int day, int month, int year);
}
