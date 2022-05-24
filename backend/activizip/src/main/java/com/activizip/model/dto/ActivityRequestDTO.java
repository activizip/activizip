package com.activizip.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivityRequestDTO {
    private String name;
    private Integer day;
    private Integer month;
    private Integer year;
    private String time;
    private String location;
    private Integer maxParticipants;
    private Double price;
    private String description;
    private String token;
}
