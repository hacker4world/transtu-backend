package com.group.transtubackend.services;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.GenererPrevuDto;
import com.group.transtubackend.dto.TourServiceResponse;
import com.group.transtubackend.entities.*;
import com.group.transtubackend.repositories.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public PointageService(AgentRepository agentRepository, DefaillanceRepository defaillanceRepository, CongeRepository congeRepository, ListToursRepository listToursRepository, UserRepository userRepository, TourServiceRepository tourServiceRepository) {
        this.agentRepository = agentRepository;
        this.defaillanceRepository = defaillanceRepository;
        this.congeRepository = congeRepository;
        this.listToursRepository = listToursRepository;
        this.userRepository = userRepository;
        this.tourServiceRepository = tourServiceRepository;
    }

    public ResponseEntity<ApiResponse<List<TourServiceResponse>>> genererTravailPrevu(GenererPrevuDto prevuData) {
        Optional<Utilisateur> u = userRepository.findByEmail(prevuData.getEmail());

        if (u.isEmpty()) return ResponseEntity.status(401).body(new ApiResponse<>("Utilisateur n'est pas trouvé"));

        Utilisateur utilisateur = u.get();

        District district = utilisateur.getDistrict();

        String saison = getSaison(prevuData.getDay(), prevuData.getMonth());

        List<ListeTours> tours = listToursRepository.findByDistrictAndJourAndSaison(district, prevuData.getDayCode(), saison);

        List<Agent> agents = agentRepository.findByDistrict(district);

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


}
