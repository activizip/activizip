package com.activizip.service;

import com.activizip.model.Activity;
import com.activizip.model.User;
import com.activizip.model.dto.ActivityRequestDTO;
import com.activizip.model.dto.ActivityResponseDTO;
import com.activizip.repository.ActivityRepository;
import com.activizip.repository.AttendanceRepository;
import com.activizip.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.activizip.util.TokenUtils.getTokenInfo;

@Service
@AllArgsConstructor
@Slf4j
public class ActivityService {

    private ActivityRepository activityRepository;
    private AttendanceRepository attendanceRepository;
    private UserRepository userRepository;

    public List<ActivityResponseDTO> getAllActivities() {
        //Method to retrieve all future activities
        log.info("Fetching all future activities");
        LocalDate yesterday = LocalDate.now().minusDays(1);
        List<Activity> activityList = activityRepository.findByDateGreaterThan(yesterday);
        List<ActivityResponseDTO> responseList = new ArrayList<>();
        for (Activity activity : activityList) {
            ActivityResponseDTO activityResponseDTO = createActivityResponseDTO(activity);
            responseList.add(activityResponseDTO);
        }
        return responseList;
    }

    public ActivityResponseDTO getActivity(long id) {
        //Method to retrieve a specific activity
        log.info("Fetching activity with id " + id);
        Optional<Activity> activity = activityRepository.findById(id);
        ActivityResponseDTO activityResponseDTO = null;
        if (activity.isPresent()) {
            log.info("Activity found");
            activityResponseDTO = createActivityResponseDTO(activity.get());
        }
        return activityResponseDTO;
    }

    public List<ActivityResponseDTO> searchActivities(String term) {
        //Method to search all activities by a text
        log.info("Fetching activity that contains '" + term + "'");
        LocalDate yesterday = LocalDate.now().minusDays(1);
        List<Activity> activityList = activityRepository.findByNameContainingIgnoreCase(term, yesterday);
        List<ActivityResponseDTO> responseList = new ArrayList<>();
        for (Activity activity : activityList) {
            ActivityResponseDTO activityResponseDTO = createActivityResponseDTO(activity);
            responseList.add(activityResponseDTO);
        }
        return responseList;
    }

    public String createActivity(ActivityRequestDTO request) {
        //Method to create a new activity
        log.info("Creating new activity");
        Pair<String, String> tokenInfo = getTokenInfo(request.getToken());
        Optional<User> user = userRepository.findByEmailAndPassword(tokenInfo.getFirst(), tokenInfo.getSecond());
        if (user.isPresent()) {
            Activity newActivity = Activity.builder()
                    .name(request.getName())
                    .description(request.getDescription())
                    .location(request.getLocation())
                    .date(LocalDate.of(request.getYear(), request.getMonth(), request.getDay()))
                    .time(request.getTime())
                    .price(request.getPrice())
                    .maxParticipants(request.getMaxParticipants())
                    .creator(user.get().getName() + " " + user.get().getLastNames())
                    .build();
            activityRepository.save(newActivity);
            log.info("Activity created");
            return "OK";
        }
        return "ERROR";
    }

    private ActivityResponseDTO createActivityResponseDTO(Activity activity) {
        //Method to create an ActivityResponseDTO object from an Activity
        int registeredPeople = attendanceRepository.findByActivityId(activity.getId()).size();
        return ActivityResponseDTO.builder()
                .id(activity.getId())
                .name(activity.getName())
                .description(activity.getDescription())
                .year(activity.getDate().getYear())
                .month(activity.getDate().getMonthValue())
                .day(activity.getDate().getDayOfMonth())
                .time(activity.getTime())
                .price(activity.getPrice())
                .maxParticipants(activity.getMaxParticipants())
                .location(activity.getLocation())
                .registered(registeredPeople)
                .build();
    }
}
