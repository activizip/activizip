package com.activizip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String location;
    private LocalDate date;
    private String time;
    private Double price;
    private Integer maxParticipants;
    private Integer registered;

}
