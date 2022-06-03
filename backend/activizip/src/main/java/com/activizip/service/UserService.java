package com.activizip.service;

import com.activizip.model.User;
import com.activizip.model.dto.LoginRequestDTO;
import com.activizip.model.dto.LoginResponseDTO;
import com.activizip.model.dto.RegisterRequestDTO;
import com.activizip.model.dto.UserResponseDTO;
import com.activizip.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static com.activizip.util.PasswordUtils.encrypt;
import static com.activizip.util.TokenUtils.createToken;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private UserRepository userRepository;

    public LoginResponseDTO login(LoginRequestDTO request) {
        //Method to verify login
        log.info("Verifying login information");
        Optional<User> userOptional = userRepository.findByEmailAndPassword(request.getEmail(), encrypt(request.getPassword()));
        LoginResponseDTO loginResponse;
        if (userOptional.isPresent()) {
            //Login OK
            log.info("Login OK");
            User user = userOptional.get();
            loginResponse = LoginResponseDTO.builder()
                    .valid(true)
                    //Create new token for user validation
                    .token(createToken(user.getEmail(), user.getPassword()))
                    .id(user.getId())
                    .build();
        } else {
            //Login ERROR
            loginResponse = LoginResponseDTO.builder()
                    .valid(false)
                    .build();
        }
        return loginResponse;
    }

    public String register(RegisterRequestDTO request) {
        //Method to register a new user
        log.info("Registering new user");
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());
        String response;
        if (optionalUser.isPresent()) {
            String email = optionalUser.get().getEmail();
            log.info("Email " + email + " already registered");
            response = "Email " + email + " already registered";
        } else {
            response = registerNewUser(request);
        }
        return response;
    }

    public UserResponseDTO getUser(Long id) {
        //Method to fetch a specific user
        log.info("Fetching User with id " + id);
        Optional<User> userOptional = userRepository.findById(id);
        UserResponseDTO userResponse;
        if (userOptional.isPresent()) {
            log.info("User found");
            User user = userOptional.get();
            userResponse = UserResponseDTO.builder()
                    .name(user.getName())
                    .lastNames(user.getLastNames())
                    .email(user.getEmail())
                    .birthdate(user.getBirthdate())
                    .build();
        } else {
            userResponse = UserResponseDTO.builder().build();
        }
        return userResponse;
    }

    private String registerNewUser(RegisterRequestDTO request) {
        //Method to create a new User
        User user = User.builder()
                .name(request.getName())
                .lastNames(request.getLastNames())
                .email(request.getEmail())
                .password(encrypt(request.getPassword()))
                .birthdate(request.getBirthDate())
                .build();
        userRepository.save(user);
        return "OK";
    }
}
