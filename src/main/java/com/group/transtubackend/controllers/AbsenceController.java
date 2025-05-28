package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.AbsenceResponseDto;
import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.services.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/absences")
public class AbsenceController {
    private final AbsenceService absenceService;

    @Autowired
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping("all")
    public ResponseEntity<ApiResponse<List<AbsenceResponseDto>>> getAllAbsences() {
        return absenceService.getAllAbsences();
    }
}
