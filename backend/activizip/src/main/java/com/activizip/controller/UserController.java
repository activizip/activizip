package com.activizip.controller;

import com.activizip.model.dto.LoginRequestDTO;
import com.activizip.model.dto.LoginResponseDTO;
import com.activizip.model.dto.RegisterRequestDTO;
import com.activizip.model.dto.UserResponseDTO;
import com.activizip.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @PostMapping
    public String register(@RequestBody RegisterRequestDTO request) {
        return userService.register(request);
    }

    @GetMapping("/{id}")
    public UserResponseDTO user(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
