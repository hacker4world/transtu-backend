package com.group.transtubackend.services;

import com.group.transtubackend.dto.CreateAgentDto;
import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GestionAgentsService {

    private final GestionAgentsService gestionAgentsService;
    private final AgentRepository agentRepository;

    @Autowired
    public GestionAgentsService(GestionAgentsService gestionAgentsService, AgentRepository agentRepository) {
        this.gestionAgentsService = gestionAgentsService;
        this.agentRepository = agentRepository;
    }

    public ResponseEntity<String> addAgent(CreateAgentDto agentData) {

        Agent agent = new Agent(
                agentData.getNom(),
                agentData.getPrenom(),
                agentData.getDate_naiss(),
                agentData.getSituation_familiale(),
                agentData.getCode_emploi_assure(),
                agentData.getCode_grade(),
                agentData.getRole()
        );

        agentRepository.save(agent);

        return ResponseEntity.ok("Agent ajouté avec succès");

    }

    public ResponseEntity<String> removeAgent(Long matricule) {
        Optional<Agent> agent = agentRepository.findById(matricule);

        if (agent.isEmpty()) return ResponseEntity.status(404).body("Agent non trouvé");

        agentRepository.delete(agent.get());

        return ResponseEntity.ok("Agent supprimé avec succès");
    }

}
