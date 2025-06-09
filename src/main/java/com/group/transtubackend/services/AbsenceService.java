package com.group.transtubackend.services;

import com.group.transtubackend.dto.AbsenceResponseDto;
import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.entities.Absence;
import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.Utilisateur;
import com.group.transtubackend.repositories.AbsenceRepository;
import com.group.transtubackend.repositories.AgentRepository;
import com.group.transtubackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbsenceService {
    private final AbsenceRepository absenceRepository;
    private final AgentRepository agentRepository;
    private final UserRepository userRepository;

    @Autowired
    public AbsenceService(AbsenceRepository absenceRepository, AgentRepository agentRepository, UserRepository userRepository) {
        this.absenceRepository = absenceRepository;
        this.agentRepository = agentRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<ApiResponse<List<AbsenceResponseDto>>> getAllAbsences() {
        List<Absence> absences = absenceRepository.findAll();

        List<AbsenceResponseDto> absenceResponseDtos = new ArrayList<>();

        for (Absence absence : absences) {
            absenceResponseDtos.add(
                    AbsenceResponseDto.builder()
                            .id(absence.getId())
                            .agentName(absence.getAgent().getNom() + " " + absence.getAgent().getPrenom())
                            .agentId(absence.getAgent().getMatricule())
                            .day(absence.getDay())
                            .month(absence.getMonth())
                            .year(absence.getYear())
                            .build()
            );
        }

        return ResponseEntity.status(200).body(new ApiResponse<>("Absence list", absenceResponseDtos));
    }

    public ResponseEntity<ApiResponse<List<AbsenceResponseDto>>> getAbsencesByAgentId(int agentId) {

        Utilisateur user = userRepository.findById(agentId)
                .orElse(null);

        List<Absence> absences = absenceRepository.findByAgent(user.getAgent());

        List<AbsenceResponseDto> absenceResponseDtos = new ArrayList<>();

        for (Absence absence : absences) {
            absenceResponseDtos.add(
                    AbsenceResponseDto.builder()
                            .id(absence.getId())
                            .agentName(absence.getAgent().getNom() + " " + absence.getAgent().getPrenom())
                            .agentId(absence.getAgent().getMatricule())
                            .day(absence.getDay())
                            .month(absence.getMonth())
                            .year(absence.getYear())
                            .build()
            );
        }

        return ResponseEntity.status(200).body(new ApiResponse<>("Absences for agent", absenceResponseDtos));
    }

}
