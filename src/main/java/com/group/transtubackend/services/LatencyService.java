package com.group.transtubackend.services;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.LatencyResponseDto;
import com.group.transtubackend.entities.Latency;
import com.group.transtubackend.entities.Utilisateur;
import com.group.transtubackend.repositories.LatencyRepository;
import com.group.transtubackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LatencyService {
    private final LatencyRepository latencyRepository;
    private final UserRepository userRepository;

    @Autowired
    public LatencyService(LatencyRepository latencyRepository, UserRepository userRepository) {
        this.latencyRepository = latencyRepository;
        this.userRepository = userRepository;
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

    public ResponseEntity<ApiResponse<List<LatencyResponseDto>>> getLatenciesByAgentId(int agentId) {
        Utilisateur user = userRepository
                .findById(agentId)
                .orElse(null);

        List<Latency> latencies = latencyRepository.findByAgent(user.getAgent());

        List<LatencyResponseDto> latencyResponseDtos = latencies.stream()
                .map(latency -> new LatencyResponseDto(
                        latency.getId(),
                        latency.getDay(),
                        latency.getMonth(),
                        latency.getYear(),
                        latency.getHours(),
                        latency.getMinutes(),
                        latency.getAgent().getNom() + " " + latency.getAgent().getPrenom(),
                        latency.getAgent().getMatricule()))
                .toList();

        return ResponseEntity.status(200).body(new ApiResponse<>("Latency list", latencyResponseDtos));
    }

}
