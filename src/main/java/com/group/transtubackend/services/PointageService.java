package com.group.transtubackend.services;

import com.group.transtubackend.dto.*;
import com.group.transtubackend.entities.*;
import com.group.transtubackend.repositories.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class PointageService {
    private final AgentRepository agentRepository;
    private final DefaillanceRepository defaillanceRepository;
    private final CongeRepository congeRepository;
    private final ListToursRepository listToursRepository;
    private final UserRepository userRepository;
    private final TourServiceRepository tourServiceRepository;
    private final AbsenceRepository absenceRepository;
    private final LatencyRepository latencyRepository;

    public PointageService(AgentRepository agentRepository, DefaillanceRepository defaillanceRepository, CongeRepository congeRepository, ListToursRepository listToursRepository, UserRepository userRepository, TourServiceRepository tourServiceRepository, AbsenceRepository absenceRepository, LatencyRepository latencyRepository) {
        this.agentRepository = agentRepository;
        this.defaillanceRepository = defaillanceRepository;
        this.congeRepository = congeRepository; 
        this.listToursRepository = listToursRepository;
        this.userRepository = userRepository;
        this.tourServiceRepository = tourServiceRepository;
        this.absenceRepository = absenceRepository;
        this.latencyRepository = latencyRepository;
    }

    public ResponseEntity<ApiResponse<List<TourServiceResponse>>> genererTravailPrevu(GenererPrevuDto prevuData) {
        Optional<Utilisateur> u = userRepository.findByEmail(prevuData.getEmail());

        if (u.isEmpty()) return ResponseEntity.status(401).body(new ApiResponse<>("Utilisateur n'est pas trouvé"));

        Utilisateur utilisateur = u.get();

        District district = utilisateur.getDistrict();

        String saison = getSaison(prevuData.getDay(), prevuData.getMonth());

        List<ListeTours> tours = listToursRepository.findByDistrictAndJourAndSaison(district, prevuData.getDayCode(), saison);

        LocalDate targetDate = LocalDate.of(prevuData.getYear(), prevuData.getMonth(), prevuData.getDay());

        List<Agent> agents = agentRepository.findByDistrict(district).stream()
                .filter(agent -> isAgentAvailableOnDate(agent, targetDate))
                .toList();

        List<Agent> drivers = new java.util.ArrayList<>(agents
                .stream()
                .filter(agent -> agent.getRole().equals("driver"))
                .toList());

        List<Agent> receivers = new java.util.ArrayList<>(agents
                .stream()
                .filter(agent -> agent.getRole().equals("receiver"))
                .toList());

        System.out.println(tours.size());
        System.out.println(drivers.size());
        System.out.println(receivers.size());

        Collections.shuffle(drivers);
        Collections.shuffle(receivers);

        List<TourService> toursServices = new ArrayList<>();

        for (int i = 0; i < tours.size(); i++) {
            ListeTours tour = tours.get(i);

            TourService tourService = TourService.builder()
                    .driver(drivers.get(i))
                    .receiver(receivers.get(i))
                    .year(prevuData.getYear())
                    .month(prevuData.getMonth())
                    .day(prevuData.getDay())
                    .tour(tour)
                    .build();

            toursServices.add(tourService);

        }

        tourServiceRepository.saveAll(toursServices);

        List<TourServiceResponse> response = new ArrayList<>();

        for (TourService tourService : toursServices) {
            TourServiceResponse tourServiceResponse = TourServiceResponse.builder()
                    .driver(tourService.getDriver().getNom())
                    .receiver(tourService.getReceiver().getNom())
                    .heuresJour(tourService.getTour().getHeures_jour())
                    .heuresNuit(tourService.getTour().getHeures_nuit())
                    .saison(saison)
                    .day(prevuData.getDay())
                    .dayCode(prevuData.getDayCode())
                    .month(prevuData.getMonth())
                    .year(prevuData.getYear())
                    .build();

            response.add(tourServiceResponse);
        }

        return ResponseEntity.ok(new ApiResponse<>("Travail prévu généré avec succès", response));


    }

    public ResponseEntity<ApiResponse<?>> fetchTours(FetchToursDto data) {
        Optional<Utilisateur> utilisateur = userRepository.findByEmail(data.getEmail());

        if (utilisateur.isEmpty()) return ResponseEntity.status(401).body(new ApiResponse<>("Email was not found"));

        District district = utilisateur.get().getDistrict();

        List<TourService> tours = tourServiceRepository.findAllByDayAndMonthAndYear(
                data.getDay(), data.getMonth(), data.getYear()
        ).stream().filter(tour -> tour.getTour().getDistrict() == district).toList();

        List<TourServiceResponseDto> toursResponse = tours.stream()
                .map(tour -> {
                    return TourServiceResponseDto.builder()
                            .tourId(tour.getId())
                            .driver(tour.getDriver().getNom())
                            .receiver(tour.getReceiver().getNom())
                            .heures_jour(tour.getTour().getHeures_jour())
                            .heures_nuit(tour.getTour().getHeures_nuit())
                            .build();
                }).toList();

        return ResponseEntity.status(200).body(new ApiResponse<>("Tours de services", toursResponse));

    }

    public ResponseEntity<ApiResponse<Void>> cancelTour(CancelTourDto dto) {
        Optional<TourService> tour = tourServiceRepository.findById(dto.getTourId());

        if (tour.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>("Tour not found"));

        tourServiceRepository.delete(tour.get());

        return ResponseEntity.status(200).body(new ApiResponse<>("Tour cancelled"));

    }
    public ResponseEntity<ApiResponse<Void>> markAgentAbsent(MarkAgentAbsentDto absenceData) {
        Optional<Agent> agent = agentRepository.findById(absenceData.getAgentId());

        if (agent.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>("Agent not found"));

        List<Absence> existingAbsences = absenceRepository.findByAgentAndDayAndMonthAndYear(
                agent.get(), absenceData.getDay(), absenceData.getMonth(), absenceData.getYear()
        );

        if (!existingAbsences.isEmpty()) return ResponseEntity.status(400).body(new ApiResponse<>("Agent already marked absent in this date"));

        Absence absence = Absence.builder()
                .agent(agent.get())
                .day(absenceData.getDay())
                .month(absenceData.getMonth())
                .year(absenceData.getYear())
                .build();

        absenceRepository.save(absence);

        return ResponseEntity.status(200).body(new ApiResponse<>("Agent marked as absent"));
    }

    public ResponseEntity<ApiResponse<Void>> markAgentLate(MarkAgentLateDto data) {
        Optional<Agent> agent = agentRepository.findById(data.getAgentId());

        if (agent.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>("Agent not found"));

        List<Absence> existingLatencies = latencyRepository.findByAgentAndDayAndMonthAndYear(
                agent.get(), data.getDay(), data.getMonth(), data.getYear()
        );

        if (!existingLatencies.isEmpty()) return ResponseEntity.status(400).body(new ApiResponse<>("Agent already marked absent in this date"));

        Latency latency = Latency.builder()
                .agent(agent.get())
                .day(data.getDay())
                .month(data.getMonth())
                .year(data.getYear())
                .hours(data.getHours())
                .minutes(data.getMinutes())
                .build();

        latencyRepository.save(latency);

        return ResponseEntity.status(200).body(new ApiResponse<>("Agent marked as late"));
    }

//    public ResponseEntity<ApiResponse<Void>> changeAgent() {}

    private String getSaison(int day, int month) {
        // Winter: December 21 - March 19
        if ((month == 12 && day >= 21) ||
                (month == 1 || month == 2) ||
                (month == 3 && day <= 19)) {
            return "winter";
        }
        // Spring: March 20 - June 20
        else if ((month == 3 && day >= 20) ||
                (month == 4 || month == 5) ||
                (month == 6 && day <= 20)) {
            return "spring";
        }
        // Summer: June 21 - September 21
        else if ((month == 6 && day >= 21) ||
                (month == 7 || month == 8) ||
                (month == 9 && day <= 21)) {
            return "summer";
        }
        // Autumn/Fall: September 22 - December 20
        else {
            return "autumn";
        }
    }

    private boolean isAgentAvailableOnDate(Agent agent, LocalDate date) {
        return !hasDefaillanceOnDate(agent, date) && !hasCongeOnDate(agent, date);
    }

    // Check if agent has a defaillance on the given date
    private boolean hasDefaillanceOnDate(Agent agent, LocalDate date) {
        return agent.getDefaillances().stream()
                .anyMatch(def -> isDateInRange(date, def.getDateDebut(), def.getDateFin()));
    }

    // Check if agent has a conge on the given date
    private boolean hasCongeOnDate(Agent agent, LocalDate date) {
        return agent.getConges().stream()
                .anyMatch(conge -> isDateInRange(date, conge.getDateDebut(), conge.getDateFin()));
    }

    // Check if a date falls within a range (inclusive)
    private boolean isDateInRange(LocalDate date, LocalDate start, LocalDate end) {
        return !date.isBefore(start) && !date.isAfter(end);
    }


}
