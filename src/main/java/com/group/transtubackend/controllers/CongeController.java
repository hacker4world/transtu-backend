package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.AjouterCongeDto;
import com.group.transtubackend.dto.AjouterCongeResponseDto;
import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.UpdateCongeDto;
import com.group.transtubackend.services.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/conge")
public class CongeController {
    private final CongeService congeService;

    @Autowired
    public CongeController(CongeService congeService) {
        this.congeService = congeService;
    }

    @GetMapping("all")
    public ResponseEntity<ApiResponse<List<AjouterCongeResponseDto>>> getAllConges() {
        return congeService.getAllConges();
    }

    @PostMapping("ajouter")
    public ResponseEntity<ApiResponse<AjouterCongeResponseDto>> ajouterConge(@RequestBody AjouterCongeDto congeData) {
        return congeService.ajouterConge(congeData);
    }

    @PostMapping("modifier")
    public ResponseEntity<ApiResponse<?>> modifierConge(@RequestBody UpdateCongeDto congeData) {
        return congeService.updateConge(congeData);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponse<?>> deleteConge(@PathVariable Long id) {
        return congeService.deleteConge(id);
    }

}
