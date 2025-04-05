package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.TourServiceResponse;
import com.group.transtubackend.services.PointageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("api/pointage")
public class PointageController {
    private final PointageService pointageService;

    public PointageController(PointageService pointageService) {
        this.pointageService = pointageService;
    }

    @GetMapping("/generer-travail-prevu")
    public ResponseEntity<List<TourServiceResponse>> genererTravailPrevu() throws ParseException {
        return pointageService.genererTravailPrevu();
    }

    @GetMapping("/get-tours/{date}")
    public ResponseEntity<List<TourServiceResponse>> getTours(@PathVariable String date) throws ParseException {
        return pointageService.getTravailPrevuByDate(date);
    }

}
