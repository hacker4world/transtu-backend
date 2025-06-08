package com.group.transtubackend.services;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.LatencyResponseDto;
import com.group.transtubackend.repositories.LatencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LatencyService {
    private final LatencyRepository latencyRepository;

    @Autowired
    public LatencyService(LatencyRepository latencyRepository) {
        this.latencyRepository = latencyRepository;
    }

    public ResponseEntity<ApiResponse<List<LatencyResponseDto>>> getAllLatencies() {
        return ResponseEntity.status(200).body(new ApiResponse<>("", latencyRepository.findAll().stream()
                .map(latency -> new LatencyResponseDto(
                        latency.getId(),
                        latency.getDay(),
                        latency.getMonth(),
                        latency.getYear(),
                        latency.getHours(),
                        latency.getMinutes(),
                        latency.getAgent().getNom() + " " + latency.getAgent().getPrenom(), latency.getAgent().getMatricule())) // Assuming Agent has getName()
                .toList()));
    }

}
