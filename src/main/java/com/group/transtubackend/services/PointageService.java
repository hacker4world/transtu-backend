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



    }



}
