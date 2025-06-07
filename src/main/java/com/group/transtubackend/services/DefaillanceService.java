package com.group.transtubackend.services;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.DefaillanceDTO;
import com.group.transtubackend.dto.DefaillanceResponse;
import com.group.transtubackend.dto.DefaillanceResponseDto;
import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.Defaillance;
import com.group.transtubackend.repositories.AgentRepository;
import com.group.transtubackend.repositories.DefaillanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DefaillanceService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private DefaillanceRepository defaillanceRepository;

    public ResponseEntity<ApiResponse<DefaillanceResponseDto>> addDefaillance(DefaillanceDTO dto) {
        Optional<Agent> agentOpt = agentRepository.findById(dto.getAgentId());

        if (agentOpt.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse<>("Agent introuvable"));
        }

        List<Defaillance> allDefaillances = defaillanceRepository.findByAgent(agentOpt.get());

        List<Defaillance> overlapping = allDefaillances.stream().filter(d -> isOverlapping(
                d.getDateDebut(), d.getDateFin(),
                dto.getDateDebut(), dto.getDateFin()
        )).toList();

        if (!overlapping.isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse<>("Cette défaillance est en conflit avec une autre défaillance pour le même agent"));
        }

        Defaillance defaillance = new Defaillance(
                dto.getNombre_jour(),
                dto.getDateDebut(),
                dto.getDateFin(),
                agentOpt.get()
        );

        Defaillance saved = defaillanceRepository.save(defaillance);

        return ResponseEntity.ok(new ApiResponse<>("Défaillance ajoutée avec succès", DefaillanceResponseDto.builder()
                .id(saved.getMatricule())
                .agentId(agentOpt.get().getMatricule())
                .agentNom(agentOpt.get().getNom())
                .agentPrenom(agentOpt.get().getPrenom())
                .dateDebut(saved.getDateDebut())
                .dateFin(saved.getDateFin())
                .build()));
    }
    public ResponseEntity<ApiResponse<Defaillance>> updateDefaillance(int id, DefaillanceDTO dto) {
        Optional<Defaillance> defOpt = defaillanceRepository.findById(id);
        Optional<Agent> agentOpt = agentRepository.findById(dto.getAgentId());

        if (defOpt.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse<>("Défaillance introuvable"));
        }

        if (agentOpt.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse<>("Agent introuvable"));
        }

        Defaillance def = defOpt.get();
        def.setNombre_jour(dto.getNombre_jour());
        def.setDateDebut(dto.getDateDebut());
        def.setDateFin(dto.getDateFin());
        def.setAgent(agentOpt.get());

        Defaillance updated = defaillanceRepository.save(def);
        return ResponseEntity.ok(new ApiResponse<>("Défaillance modifiée avec succès"));
    }

    public ResponseEntity<ApiResponse<Void>> deleteDefaillance(int id) {
        if (!defaillanceRepository.existsById(id)) {
            return ResponseEntity.status(404).body(new ApiResponse<>("Défaillance introuvable"));
        }
        defaillanceRepository.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>("Défaillance supprimée avec succès"));
    }


    public List<DefaillanceResponse> getAllDefaillances() {
        List<Defaillance> defaillances = defaillanceRepository.findAll();

        return defaillances.stream()
                .map(defaillance -> new DefaillanceResponse(
                        defaillance.getMatricule(),
                        defaillance.getNombre_jour(),
                        defaillance.getDateDebut(),
                        defaillance.getDateFin(),
                        defaillance.getAgent().getMatricule(),
                        defaillance.getAgent().getNom(),
                        defaillance.getAgent().getPrenom()
                ))
                .collect(Collectors.toList());
    }

    public DefaillanceResponse getDefaillanceById(int id) {
        return defaillanceRepository.findById(id)
                .map(defaillance -> new DefaillanceResponse(
                        defaillance.getMatricule(),
                        defaillance.getNombre_jour(),
                        defaillance.getDateDebut(),
                        defaillance.getDateFin(),
                        defaillance.getAgent().getMatricule(),
                        defaillance.getAgent().getNom(),
                        defaillance.getAgent().getPrenom()
                ))
                .orElse(null);
    }

    private boolean isOverlapping(
            LocalDate defStart, LocalDate defEnd,
            LocalDate searchStart, LocalDate searchEnd) {

        // Check if the defaillance range overlaps with search range
        return !defStart.isAfter(searchEnd) && !defEnd.isBefore(searchStart);
    }


}
