package com.group.transtubackend.services;

import com.group.transtubackend.dto.TourServiceDto;
import com.group.transtubackend.entities.Agent;
import com.group.transtubackend.entities.TourService;
import com.group.transtubackend.repositories.AgentRepository;
import com.group.transtubackend.repositories.TourServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TourServiceService {

    @Autowired
    private TourServiceRepository tourServiceRepository;

    @Autowired
    private AgentRepository agentRepository;

    public String ajouterTourService(TourServiceDto tourServiceDto) {
        LocalDate demain = LocalDate.now().plusDays(1);


        List<Agent> Chauffeurs = agentRepository.findByRole("Chauffeur");
        List<Agent> Receveurs = agentRepository.findByRole("Receveur");

        Random random = new Random();

        Agent chauffeurAleatoire = null;
        Agent receveurAleatoire = null;


        while (chauffeurAleatoire == null || receveurAleatoire == null) {

            if (!Chauffeurs.isEmpty()) {
                chauffeurAleatoire = Chauffeurs.get(random.nextInt(Chauffeurs.size()));
            }
            if (!Receveurs.isEmpty()) {
                receveurAleatoire = Receveurs.get(random.nextInt(Receveurs.size()));
            }


            Optional<TourService> chauffeurExist = tourServiceRepository.findByChauffeur(chauffeurAleatoire);
            Optional<TourService> receveurExist = tourServiceRepository.findByReceveur(receveurAleatoire);


            if (chauffeurExist.isPresent()) {
                chauffeurAleatoire = null;
            }
            if (receveurExist.isPresent()) {
                receveurAleatoire = null;
            }
        }


        TourService tourService = new TourService(
                chauffeurAleatoire,
                tourServiceDto.getCode_etat_enregistrement(),
                receveurAleatoire,
                tourServiceDto.getPanier(),
                tourServiceDto.getHeure_nuit(),
                tourServiceDto.getHeure_jour(),
                tourServiceDto.getCode_jour_bareme(),
                tourServiceDto.getTravail_assure(),
                tourServiceDto.getNumero_tour_service(),
                tourServiceDto.getType_bareme(),
                demain.getDayOfMonth(),
                demain.getMonthValue(),
                demain.getYear()
        );


        tourServiceRepository.save(tourService);

        return "Enregistrement avec succès";
    }
}
