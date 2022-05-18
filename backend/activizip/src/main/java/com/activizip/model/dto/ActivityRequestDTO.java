package com.activizip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityRequestDTO {

    private String name;
    private String description;
    private String location;
    private Integer year;
    private Integer month;
    private Integer day;
    private String time;
    private Double price;
    private Integer maxParticipants;
    private String token;

}
