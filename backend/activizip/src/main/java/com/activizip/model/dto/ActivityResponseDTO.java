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
    private Integer day;
    private Integer month;
    private Integer year;
    private String time;
    private String location;
    private Integer maxParticipants;
    private Double price;
    private String description;
    private Integer registered;
}
