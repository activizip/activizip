package com.activizip.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterRequestDTO {

    private String name;
    private String lastNames;
    private String email;
    private String password;
    private LocalDate birthDate;

}
