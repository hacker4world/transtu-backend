package com.group.transtubackend.controllers;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.CreateAgentDto;
import com.group.transtubackend.dto.LoginResponseDto;
import com.group.transtubackend.dto.CreateEmployeeDto;
import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.services.GestionAgentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/agent")
public class GestionAgentsController {
    private final GestionAgentsService gestionAgentsService;

    @Autowired
    public GestionAgentsController(GestionAgentsService gestionAgentsService) {
        this.gestionAgentsService = gestionAgentsService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Agent>> getAllAgents() {
        List<Agent> agents = gestionAgentsService.getAllAgents();
        return ResponseEntity.ok(agents);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAgent(@RequestBody CreateAgentDto agentData) {
        return gestionAgentsService.addAgent(agentData);
    }

    @DeleteMapping("/remove/{matricule}")
    public ResponseEntity<String> removeAgent(@PathVariable int matricule) {
        return gestionAgentsService.removeAgent(matricule);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAgent(@PathVariable int id, @RequestBody CreateAgentDto agentData) {
        return gestionAgentsService.UpdateAgent(id, agentData);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable int id) {
        return gestionAgentsService.getAgentById(id);
    }
    }


