package com.activizip.service;

import com.activizip.model.User;
import com.activizip.model.dto.LoginRequestDTO;
import com.activizip.model.dto.LoginResponseDTO;
import com.activizip.model.dto.RegisterRequestDTO;
import com.activizip.model.dto.UserResponseDTO;
import com.activizip.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.activizip.util.PasswordUtils.encrypt;
import static com.activizip.util.TokenUtils.createToken;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public LoginResponseDTO login(LoginRequestDTO request) {
        return userRepository.findByEmailAndPassword(request.getEmail(), encrypt(request.getPassword()))
                .map(user -> LoginResponseDTO.builder()
                        .valid(true)
                        .token(createToken(user.getEmail(), user.getPassword()))
                        .id(user.getId())
                        .build())
                .orElseGet(() -> LoginResponseDTO.builder()
                        .valid(false)
                        .build());
    }

    public String register(RegisterRequestDTO request) {
        return userRepository.findByEmail(request.getEmail())
                .map(u -> "Email " + u.getEmail() + " already registered")
                .orElseGet(() -> registerNewUser(request));
    }

    public UserResponseDTO getUser(Long id) {
        return userRepository.findById(id)
                .map(user -> UserResponseDTO.builder()
                        .name(user.getName())
                        .lastNames(user.getLastNames())
                        .email(user.getEmail())
                        .birthdate(user.getBirthdate())
                        .build())
                .orElseGet(UserResponseDTO::new);
    }

    private String registerNewUser(RegisterRequestDTO request) {
        userRepository.save(User.builder()
                .name(request.getName())
                .lastNames(request.getLastNames())
                .email(request.getEmail())
                .password(encrypt(request.getPassword()))
                .birthdate(LocalDate.of(request.getYear(), request.getMonth(), request.getDay()))
                .build());
        return "OK";
    }
}
