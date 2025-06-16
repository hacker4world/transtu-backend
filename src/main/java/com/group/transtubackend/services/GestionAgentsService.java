package com.group.transtubackend.services;

import com.group.transtubackend.dto.AgentResponse;
import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.CreateAgentDto;
import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.TourService;
import com.group.transtubackend.entities.Utilisateur;
import com.group.transtubackend.repositories.AgentRepository;
import com.group.transtubackend.repositories.TourServiceRepository;
import com.group.transtubackend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionAgentsService {

    private final AgentRepository agentRepository;
    private final UserRepository userRepository;
    private final TourServiceRepository tourServiceRepository;

    @Autowired
    public GestionAgentsService(AgentRepository agentRepository, UserRepository userRepository, TourServiceRepository tourServiceRepository) {
        this.agentRepository = agentRepository;
        this.userRepository = userRepository;
        this.tourServiceRepository = tourServiceRepository;
    }

    public ResponseEntity<ApiResponse<Agent>> addAgent(CreateAgentDto agentData) {

        Optional<Utilisateur> utilisateur = userRepository.findById(agentData.getAdminId());

        if (utilisateur.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>("Admin n'est pas trouver"));

        Optional<Utilisateur> agentUser = userRepository.findByEmail(agentData.getEmail());

        if (agentUser.isPresent()) {
            return ResponseEntity.status(400).body(new ApiResponse<>("Email est deja utilise"));
        }


        Utilisateur newUser = Utilisateur.builder()
                .nom(agentData.getNom())
                .prenom(agentData.getPrenom())
                .email(agentData.getEmail())
                .password(agentData.getPassword())
                .role("agent")
                .district(utilisateur.get().getDistrict())
                .build();

        Agent agent = Agent.builder()
                .nom(agentData.getNom())
                .prenom(agentData.getPrenom())
                .date_naiss(agentData.getDate_naiss())
                .situation_familiale(agentData.getSituation_familiale())
                .role(agentData.getRole())
                .district(utilisateur.get().getDistrict())
                .build();

        newUser.setAgent(agent);
        agent.setUtilisateur(newUser);

        userRepository.save(newUser);
        agentRepository.save(agent);

        return ResponseEntity.ok(new ApiResponse<>("Agent a ete cree", agent));

    }

    @Transactional
    public ResponseEntity<ApiResponse<String>> removeAgent(int matricule) {
        Optional<Agent> agent = agentRepository.findById(matricule);

        if (agent.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>("Agent n'est pas trouver"));

        List<TourService> tours = tourServiceRepository.findByAgent(agent.get());

        tours.forEach(tour -> {
            if (tour.getDriver() == agent.get()) tour.setDriver(null);
            else if (tour.getReceiver() == agent.get()) tour.setReceiver(null);
        });

        tourServiceRepository.saveAll(tours);

        agentRepository.delete(agent.get());

        userRepository.delete(agent.get().getUtilisateur());

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
            agent.setRole(agentData.getRole());

            Utilisateur utilisateur = agent.getUtilisateur();

            utilisateur.setNom(agentData.getNom());
            utilisateur.setPrenom(agentData.getPrenom());

            agentRepository.save(agent);

            userRepository.save(utilisateur);
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
                .email(agent.getUtilisateur().getEmail())
                .role(agent.getRole())
                .district(agent.getDistrict().getName())
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
