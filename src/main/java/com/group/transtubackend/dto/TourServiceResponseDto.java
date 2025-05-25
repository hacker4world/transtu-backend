package com.group.transtubackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TourServiceResponseDto {
    private Long tourId;
    private String driver;
    private int driverId;
    private String receiver;
    private int receiverId;
    private int heures_jour;
    private int heures_nuit;

    public TourServiceResponseDto(Long tourId, String driver, int driverId, String receiver, int receiverId, int heures_jour, int heures_nuit) {
        this.tourId = tourId;
        this.driver = driver;
        this.driverId = driverId;
        this.receiver = receiver;
        this.receiverId = receiverId;
        this.heures_jour = heures_jour;
        this.heures_nuit = heures_nuit;
    }
}
