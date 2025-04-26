package com.group.transtubackend.services;

import com.group.transtubackend.dto.AgentResponse;
import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.CreateAgentDto;
import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.Utilisateur;
import com.group.transtubackend.repositories.AgentRepository;
import com.group.transtubackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionAgentsService {

    private final AgentRepository agentRepository;
    private final UserRepository userRepository;

    @Autowired
    public GestionAgentsService(AgentRepository agentRepository, UserRepository userRepository) {
        this.agentRepository = agentRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<ApiResponse<Agent>> addAgent(CreateAgentDto agentData) {

        Optional<Utilisateur> utilisateur = userRepository.findById(agentData.getAdminId());

        if (utilisateur.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>("Admin n'est pas trouver"));

        Agent agent = new Agent(
                agentData.getNom(),
                agentData.getPrenom(),
                agentData.getDate_naiss(),
                agentData.getSituation_familiale(),
                agentData.getCode_emploi_assure(),
                agentData.getCode_grade(),
                agentData.getRole(),
                utilisateur.get().getDistrict()
        );

        Agent savedAgent = agentRepository.save(agent);

        return ResponseEntity.ok(new ApiResponse<>("Agent a ete cree", savedAgent));

    }

    public ResponseEntity<ApiResponse<String>> removeAgent(int matricule) {
        Optional<Agent> agent = agentRepository.findById(matricule);

        if (agent.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>("Agent n'est pas trouver"));

        agentRepository.delete(agent.get());

        return ResponseEntity.ok(new ApiResponse<>("Agent a ete supprime"));
    }
    public ResponseEntity<ApiResponse<String>> UpdateAgent(int id, CreateAgentDto agentData) {
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
            return ResponseEntity.ok(new ApiResponse<>("Agent a ete mis a jour"));
        } else {
            return ResponseEntity.ok(new ApiResponse<>("Agent n'est pas trouver"));
        }
    }
    public ResponseEntity<List<AgentResponse>> getAllAgents() {
        List<Agent> agents = agentRepository.findAll();

        List<AgentResponse> agentsResponse =  agents.stream().map(agent -> AgentResponse.builder()
                .matricule(agent.getMatricule())
                .nom(agent.getNom())
                .prenom(agent.getPrenom())
                .date_naiss(agent.getDate_naiss())
                .situation_familiale(agent.getSituation_familiale())
                .code_emploi_assure(agent.getCode_emploi_assure())
                .code_grade(agent.getCode_grade())
                .role(agent.getRole())
                .departement(agent.getDistrict().getName())
                .build()).toList();

        return ResponseEntity.ok(agentsResponse);

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
