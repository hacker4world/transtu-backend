package com.group.transtubackend.services;

import com.group.transtubackend.dto.TourServiceResponse;
import com.group.transtubackend.entities.*;
import com.group.transtubackend.repositories.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class PointageService {
    private final LigneRepository ligneRepository;
    private final AgentRepository agentRepository;
    private final DefaillanceRepository defaillanceRepository;
    private final CongeRepository congeRepository;
    private final TourServiceRepository tourServiceRepository;

    public PointageService(LigneRepository ligneRepository, AgentRepository agentRepository, DefaillanceRepository defaillanceRepository, CongeRepository congeRepository, TourServiceRepository tourServiceRepository) {
        this.ligneRepository = ligneRepository;
        this.agentRepository = agentRepository;
        this.defaillanceRepository = defaillanceRepository;
        this.congeRepository = congeRepository;
        this.tourServiceRepository = tourServiceRepository;
    }

    public ResponseEntity<List<TourServiceResponse>> genererTravailPrevu() throws ParseException {

        LocalDate targetDate = getNextDay();

        List<Agent> availableAgents = agentRepository.findAgentsWithNoDefaillanceOrCongeOnDate(targetDate);

        List<Ligne> lignes = ligneRepository.findAll();

        List<Agent> assignedAgents = new ArrayList<>();

        List<TourServiceResponse> responses = new ArrayList<>();

        for (Ligne ligne : lignes) {
            Agent chauffeur = selectRandomDriver(availableAgents, assignedAgents);
            Agent receveur = selectRandomReceiver(availableAgents, assignedAgents);

            assignedAgents.add(chauffeur);
            assignedAgents.add(receveur);

            System.out.println("reached here");

            TourService tourService = TourService.builder()
                    .date(targetDate)
                    .type_bareme("hiver")
                    .travail_assure("continue")
                    .panier("panier-id")
                    .code_etat_enregistrement("enregistre")
                    .chauffeur(chauffeur)
                    .receveur(receveur)
                    .ligne(ligne)
                    .build();

            tourServiceRepository.save(tourService);

            responses.add(new TourServiceResponse(tourService.getCode_service(), targetDate, "hiver", "continue", "na3rech", "panier-id", "enregistre", chauffeur.getMatricule(), receveur.getMatricule(), ligne.getId()));

        }

        return ResponseEntity.ok(responses);

    }

    public ResponseEntity<List<TourServiceResponse>> getTravailPrevuByDate(String date) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate targetDate = LocalDate.parse(date, formatter);

        List<TourService> tourServices = tourServiceRepository.findByDate(targetDate);

        List<TourServiceResponse> responses = new ArrayList<>();

        for (TourService tourService : tourServices) {
            responses.add(new TourServiceResponse(tourService.getCode_service(), tourService.getDate(), "hiver", "continue", "na3rech", "panier-id", "enregistre", tourService.getChauffeur().getMatricule(), tourService.getReceveur().getMatricule(), tourService.getLigne().getId()));
        }

        return ResponseEntity.ok(responses);
    }

    private LocalDate getNextDay() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);

        return tomorrow;
    }

    private Agent selectRandomDriver(List<Agent> availableAgents, List<Agent> assignedAgents) {
        Random random = new Random();
        int randomIndex = random.nextInt(availableAgents.size());
        Agent randomAgent = availableAgents.get(randomIndex);

        while(!randomAgent.getRole().equals("chauffeur") || assignedAgents.contains(randomAgent)) {
            randomIndex = random.nextInt(availableAgents.size());
            randomAgent = availableAgents.get(randomIndex);
        }

        return randomAgent;

    }

    private Agent selectRandomReceiver(List<Agent> availableAgents, List<Agent> assignedAgents) {
        Random random = new Random();
        int randomIndex = random.nextInt(availableAgents.size());
        Agent randomAgent = availableAgents.get(randomIndex);

        while(!randomAgent.getRole().equals("receveur") || assignedAgents.contains(randomAgent)) {
            randomIndex = random.nextInt(availableAgents.size());
            randomAgent = availableAgents.get(randomIndex);
        }

        return randomAgent;

    }

}
