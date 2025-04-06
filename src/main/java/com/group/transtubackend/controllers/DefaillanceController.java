package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.DefaillanceDTO;
import com.group.transtubackend.dto.DefaillanceResponse;
import com.group.transtubackend.entities.Defaillance;
import com.group.transtubackend.services.DefaillanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/defaillances")
public class DefaillanceController {

    @Autowired
    private DefaillanceService defaillanceService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Defaillance>> addDefaillance(@RequestBody DefaillanceDTO dto) {
        return defaillanceService.addDefaillance(dto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Defaillance>> updateDefaillance(@PathVariable int id, @RequestBody DefaillanceDTO dto) {
        return defaillanceService.updateDefaillance(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteDefaillance(@PathVariable int id) {
        return defaillanceService.deleteDefaillance(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<DefaillanceResponse>> getAllDefaillances() {
        List<DefaillanceResponse> defaillances = defaillanceService.getAllDefaillances();
        return ResponseEntity.ok(defaillances);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DefaillanceResponse> getDefaillanceById(@PathVariable int id) {
        DefaillanceResponse defaillance = defaillanceService.getDefaillanceById(id);
        if (defaillance == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(defaillance);
    }





}
