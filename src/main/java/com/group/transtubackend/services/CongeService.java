package com.group.transtubackend.services;

import com.group.transtubackend.dto.AjouterCongeDto;
import com.group.transtubackend.dto.AjouterCongeResponseDto;
import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.UpdateCongeDto;
import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.Conge;
import com.group.transtubackend.repositories.AgentRepository;
import com.group.transtubackend.repositories.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CongeService {
    private final CongeRepository congeRepository;
    private final AgentRepository agentRepository;

    @Autowired
    public CongeService(CongeRepository congeRepository, AgentRepository agentRepository) {
        this.congeRepository = congeRepository;
        this.agentRepository = agentRepository;
    }

    public ResponseEntity<ApiResponse<AjouterCongeResponseDto>> ajouterConge(AjouterCongeDto congeData) {
        Optional<Agent> agentOpt = agentRepository.findById(congeData.getAgentId());

        if (agentOpt.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse<>("Agent introuvable"));
        }

        int nbrJours = congeData.getDateFin().getDayOfYear() - congeData.getDateDebut().getDayOfYear();

        Conge conge = Conge.builder()
                .agent(agentOpt.get())
                .dateDebut(congeData.getDateDebut())
                .dateFin(congeData.getDateFin())
                .nbr_jour(nbrJours)
                .build();

        Conge savedConge = congeRepository.save(conge);

        AjouterCongeResponseDto responseDto = AjouterCongeResponseDto.builder()
                .id(savedConge.getMatricule())
                .dateDebut(savedConge.getDateDebut())
                .dateFin(savedConge.getDateFin())
                .nbrJours(savedConge.getNbr_jour())
                .agentId(agentOpt.get().getMatricule())
                .agentName(agentOpt.get().getNom() + " " + agentOpt.get().getPrenom())
                .build();

        return ResponseEntity.ok(new ApiResponse<>("Congé ajouté avec succès", responseDto));

    }

    public ResponseEntity<ApiResponse<List<AjouterCongeResponseDto>>> getAllConges() {
        List<Conge> conges = congeRepository.findAll();
        List<AjouterCongeResponseDto> responseDtos = conges.stream().map(conge -> {
            Agent agent = conge.getAgent();
            return AjouterCongeResponseDto.builder()
                    .id(conge.getMatricule())
                    .dateDebut(conge.getDateDebut())
                    .dateFin(conge.getDateFin())
                    .nbrJours(conge.getNbr_jour())
                    .agentId(agent.getMatricule())
                    .agentName(agent.getNom() + " " + agent.getPrenom())
                    .build();
        }).toList();

        return ResponseEntity.ok(new ApiResponse<>("Liste des congés récupérée avec succès", responseDtos));
    }

    public ResponseEntity<ApiResponse<?>> deleteConge(Long congeId) {
        Optional<Conge> congeOpt = congeRepository.findById(congeId);

        if (congeOpt.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>("Conge n'est pas trouve"));

        congeRepository.delete(congeOpt.get());

        return ResponseEntity.ok(new ApiResponse<>("Conge est supprimé"));

    }

    public ResponseEntity<ApiResponse<?>> updateConge(UpdateCongeDto congeData) {
        Optional<Conge> congeOpt = congeRepository.findById(congeData.getId());

        if (congeOpt.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>("Conge n'est pas trouve"));

        Conge conge = congeOpt.get();

        conge.setDateDebut(congeData.getDateDebut());
        conge.setDateFin(congeData.getDateFin());
        conge.setNbr_jour(congeData.getDateFin().getDayOfYear() - congeData.getDateDebut().getDayOfYear());

        congeRepository.save(conge);

        return ResponseEntity.ok(new ApiResponse<>("Conge updated"));
    }
}
