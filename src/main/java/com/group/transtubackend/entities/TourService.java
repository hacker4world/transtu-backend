package com.group.transtubackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Agent driver;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Agent receiver;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private ListeTours tour;

    private int day;
    private int month;
    private int year;
}
