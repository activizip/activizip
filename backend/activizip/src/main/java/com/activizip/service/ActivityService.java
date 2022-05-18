package com.activizip.service;

import com.activizip.model.Activity;
import com.activizip.model.User;
import com.activizip.model.dto.ActivityRequestDTO;
import com.activizip.model.dto.ActivityResponseDTO;
import com.activizip.repository.ActivityRepository;
import com.activizip.repository.AttendanceRepository;
import com.activizip.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.activizip.util.TokenUtils.getTokenInfo;

@Service
@AllArgsConstructor
public class ActivityService {

    private ActivityRepository activityRepository;
    private AttendanceRepository attendanceRepository;
    private UserRepository userRepository;

    public List<ActivityResponseDTO> getAllActivities() {
        return activityRepository.findByDateGreaterThan(LocalDate.now()).stream()
                .map(this::createActivityResponseDTO)
                .collect(Collectors.toList());
    }

    public ActivityResponseDTO getActivity(long id) {
        return activityRepository.findById(id)
                .map(this::createActivityResponseDTO)
                .orElseGet(null);
    }

    public List<ActivityResponseDTO> searchActivities(String term) {
        return activityRepository.findByNameContainingIgnoreCase(term).stream()
                .map(this::createActivityResponseDTO)
                .collect(Collectors.toList());
    }

    public String createActivity(ActivityRequestDTO request) {
        Pair<String, String> tokenInfo = getTokenInfo(request.getToken());
        Optional<User> user = userRepository.findByEmailAndPassword(tokenInfo.getFirst(), tokenInfo.getSecond());
        if (user.isPresent()) {
            activityRepository.save(Activity.builder()
                    .name(request.getName())
                    .description(request.getDescription())
                    .location(request.getLocation())
                    .date(LocalDate.of(request.getYear(), request.getMonth(), request.getDay()))
                    .time(request.getTime())
                    .price(request.getPrice())
                    .maxParticipants(request.getMaxParticipants())
                    .creator(user.get().getName() + " " + user.get().getLastNames())
                    .build());
            return "OK";
        }
        return "ERROR";
    }

    private ActivityResponseDTO createActivityResponseDTO(Activity activity) {
        return ActivityResponseDTO.builder()
                .id(activity.getId())
                .name(activity.getName())
                .description(activity.getDescription())
                .date(activity.getDate())
                .time(activity.getTime())
                .price(activity.getPrice())
                .maxParticipants(activity.getMaxParticipants())
                .location(activity.getLocation())
                .registered(attendanceRepository.findByActivityId(activity.getId()).size())
                .build();
    }
}
