package com.group.transtubackend.repositories;

import com.group.transtubackend.entities.District;
import com.group.transtubackend.entities.ListeTours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListToursRepository extends JpaRepository<ListeTours, Integer> {
    List<ListeTours> findByDistrictAndJourAndSaison(District district, int jour, String saison);

}
