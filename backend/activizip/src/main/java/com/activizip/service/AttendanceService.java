package com.activizip.service;

import com.activizip.model.Activity;
import com.activizip.model.Attendance;
import com.activizip.model.User;
import com.activizip.model.dto.JoinRequestDTO;
import com.activizip.repository.ActivityRepository;
import com.activizip.repository.AttendanceRepository;
import com.activizip.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.activizip.util.TokenUtils.getTokenInfo;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
@Slf4j
public class AttendanceService {

    private UserRepository userRepository;
    private ActivityRepository activityRepository;
    private AttendanceRepository attendanceRepository;

    public String join(JoinRequestDTO request) {
        //Method to make a user join an activity
        Pair<String, String> tokenInfo = getTokenInfo(request.getToken());
        //Search user from token
        Optional<User> userOptional = userRepository.findByEmailAndPassword(tokenInfo.getFirst(), tokenInfo.getSecond());
        String response;
        if (userOptional.isPresent()) {
            //If user is OK
            User user = userOptional.get();
            log.info("Joining user " + user.getId() +" to activity " + request.getActivityId());
            //Search activity
            Optional<Activity> activityOptional = activityRepository.findById(request.getActivityId());
            if (activityOptional.isPresent()) {
                //If activity is OK
                Activity activity = activityOptional.get();
                //Search attendance to verify if user has already joined the activity
                Optional<Attendance> attendanceOptional = attendanceRepository.findByActivityIdAndUserId(activity.getId(), user.getId());
                if (attendanceOptional.isPresent()) {
                    response = "Already joined";
                } else {
                    response = joinUser(user.getId(), activity.getId());
                }
            } else {
                response = "ERROR IN ACTIVITY ID";
            }
        } else {
            response = "ERROR IN USER ID";
        }
        return response;
    }

    private String joinUser(Long userId, Long activityId) {
        Attendance attendance = Attendance.builder()
                .userId(userId)
                .activityId(activityId)
                .build();
        attendanceRepository.save(attendance);
        log.info("User join the activity successfully");
        return "OK";
    }
}
