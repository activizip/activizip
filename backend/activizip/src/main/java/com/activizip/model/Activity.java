package com.activizip.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Activity {

    @Id
    private Long id;
    private String name;
    private String date;
    private String time;
    private Double price;
    private Integer maxParticipants;

}
