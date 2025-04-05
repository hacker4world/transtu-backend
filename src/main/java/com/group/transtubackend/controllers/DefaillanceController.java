package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.DefaillanceDTO;
import com.group.transtubackend.entities.Defaillance;
import com.group.transtubackend.services.DefaillanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/defaillances")
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

}
