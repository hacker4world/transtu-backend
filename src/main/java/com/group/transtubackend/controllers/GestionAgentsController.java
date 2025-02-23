package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.LoginResponseDto;
import com.group.transtubackend.dto.CreateEmployeeDto;
import com.group.transtubackend.services.GestionAgentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class GestionAgentsController {
    private final GestionAgentsService gestionAgentsService;

    @Autowired
    public GestionAgentsController(GestionAgentsService gestionAgentsService) {
        this.gestionAgentsService = gestionAgentsService;
    }
}
