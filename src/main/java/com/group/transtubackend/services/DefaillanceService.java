package com.group.transtubackend.services;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.DefaillanceDTO;
import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.Defaillance;
import com.group.transtubackend.repositories.AgentRepository;
import com.group.transtubackend.repositories.DefaillanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DefaillanceService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private DefaillanceRepository defaillanceRepository;

    public ResponseEntity<ApiResponse<Defaillance>> addDefaillance(DefaillanceDTO dto) {
        Optional<Agent> agentOpt = agentRepository.findById(dto.getAgentId());

        if (agentOpt.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse<>("Agent introuvable"));
        }

        Defaillance defaillance = new Defaillance(
                dto.getNombre_jour(),
                dto.getDateDebut(),
                dto.getDateFin(),
                dto.getHeureDebut(),
                dto.getHeureFin(),
                dto.getNbre_heure(),
                agentOpt.get()
        );

        Defaillance saved = defaillanceRepository.save(defaillance);

        return ResponseEntity.ok(new ApiResponse<>("Défaillance ajoutée avec succès"));
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
        def.setHeureDebut(dto.getHeureDebut());
        def.setHeureFin(dto.getHeureFin());
        def.setNbre_heure(dto.getNbre_heure());
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

}
