package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.TourServiceDto;
import com.group.transtubackend.services.TourServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tourservice") // URL de base pour cette ressource
public class TourServiceController {

    @Autowired
    private TourServiceService tourServiceService;

    /**
     * hathi ajout
     * name=hamdi
     */
    @PostMapping("/ajouter")
    public String ajouterTourService(@RequestBody TourServiceDto tourServiceDto) {
        return tourServiceService.ajouterTourService(tourServiceDto);
    }
}