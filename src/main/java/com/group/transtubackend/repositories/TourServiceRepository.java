package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.TourService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourServiceRepository extends JpaRepository<TourService, Long> {
}
