package com.group.transtubackend.services;

import com.group.transtubackend.dto.CreateAgentDto;
import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionAgentsService {

    private final AgentRepository agentRepository;

    @Autowired
    public GestionAgentsService(AgentRepository agentRepository) {
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

    public ResponseEntity<String> removeAgent(int matricule) {
        Optional<Agent> agent = agentRepository.findById(matricule);

        if (agent.isEmpty()) return ResponseEntity.status(404).body("Agent non trouvé");

        agentRepository.delete(agent.get());

        return ResponseEntity.ok("Agent supprimé avec succès");
    }
    public ResponseEntity<String> UpdateAgent(int id, CreateAgentDto agentData) {
        Optional<Agent> existingAgent = agentRepository.findById(id);

        if (existingAgent.isPresent()) {
            Agent agent = existingAgent.get();
            agent.setNom(agentData.getNom());
            agent.setPrenom(agentData.getPrenom());
            agent.setDate_naiss(agentData.getDate_naiss());
            agent.setSituation_familiale(agentData.getSituation_familiale());
            agent.setCode_emploi_assure(agentData.getCode_emploi_assure());
            agent.setCode_grade(agentData.getCode_grade());
            agent.setRole(agentData.getRole());

            agentRepository.save(agent);
            return ResponseEntity.ok("Agent mis à jour avec succès");
        } else {
            return ResponseEntity.ok("Agent n'est pas trouver");
        }
    }
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }
    public ResponseEntity<Agent> getAgentById(int id) {
        Optional<Agent> agent = agentRepository.findById(id);

        if (agent.isPresent()) {
            return ResponseEntity.ok(agent.get());
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
