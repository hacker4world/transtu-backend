package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.entities.LatencyResponseDto;
import com.group.transtubackend.services.LatencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/latency")
public class LatencyController {
    private final LatencyService latencyService;

    @Autowired
    public LatencyController(LatencyService latencyService) {
        this.latencyService = latencyService;
    }

    @GetMapping("all")
    public ResponseEntity<ApiResponse<List<LatencyResponseDto>>> getAllLatencies() {
        return latencyService.getAllLatencies();
    }

}
