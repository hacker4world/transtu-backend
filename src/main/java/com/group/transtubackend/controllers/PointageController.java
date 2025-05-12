package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.*;
import com.group.transtubackend.services.PointageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pointage")
public class PointageController {
    private final PointageService pointageService;

    public PointageController(PointageService pointageService) {
        this.pointageService = pointageService;
    }

    @PostMapping("prevu")
    public ResponseEntity<ApiResponse<List<TourServiceResponse>>> genererTravailPrevu(@RequestBody GenererPrevuDto prevuData) {
        return pointageService.genererTravailPrevu(prevuData);
    }

    @GetMapping("tours")
    public ResponseEntity<ApiResponse<?>> fetchTours(@RequestBody FetchToursDto data) {
        return pointageService.fetchTours(data);
    }

    @PostMapping("cancel-tour")
    public ResponseEntity<ApiResponse<Void>> cancelTour(@RequestBody CancelTourDto data) {
        return pointageService.cancelTour(data);
    }

    @PostMapping("mark-absent")
    public ResponseEntity<ApiResponse<Void>> markAbsent(@RequestBody MarkAgentAbsentDto data) {
        return pointageService.markAgentAbsent(data);
    }

    @PostMapping("mark-late")
    public ResponseEntity<ApiResponse<Void>> markLate(@RequestBody MarkAgentLateDto data) {
        return pointageService.markAgentLate(data);
    }

    @PostMapping("change-agent")
    public ResponseEntity<ApiResponse<Void>> changeAgent(@RequestBody ChangeAgentDto data) {
        return pointageService.changeAgent(data);
    }

}
