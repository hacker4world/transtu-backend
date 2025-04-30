package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.GenererPrevuDto;
import com.group.transtubackend.dto.TourServiceResponse;
import com.group.transtubackend.services.PointageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/pointage")
public class PointageController {
    private final PointageService pointageService;

    public PointageController(PointageService pointageService) {
        this.pointageService = pointageService;
    }

    @PostMapping("/generer")
    public ResponseEntity<ApiResponse<List<TourServiceResponse>>> genererTravailPrevu(GenererPrevuDto prevuData) {
        return pointageService.genererTravailPrevu(prevuData);
    }

}
