package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.LatencyResponseDto;
import com.group.transtubackend.services.LatencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("agent/{agentId}")
    public ResponseEntity<ApiResponse<List<LatencyResponseDto>>> getLatenciesByAgentId(@PathVariable int agentId) {
        return latencyService.getLatenciesByAgentId(agentId);
    }

}
