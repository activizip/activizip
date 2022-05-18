package com.activizip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    private String name;
    private String lastNames;
    private String email;
    private String password;
    private Integer year;
    private Integer month;
    private Integer day;

}
