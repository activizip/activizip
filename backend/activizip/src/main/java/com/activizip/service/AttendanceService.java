package com.activizip.service;

import com.activizip.model.Attendance;
import com.activizip.model.dto.JoinRequestDTO;
import com.activizip.repository.ActivityRepository;
import com.activizip.repository.AttendanceRepository;
import com.activizip.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import static com.activizip.util.TokenUtils.getTokenInfo;

@Service
@AllArgsConstructor
public class AttendanceService {

    private UserRepository userRepository;
    private ActivityRepository activityRepository;
    private AttendanceRepository attendanceRepository;

    public String join(JoinRequestDTO request) {
        Pair<String, String> tokenInfo = getTokenInfo(request.getToken());
        return userRepository.findByEmailAndPassword(tokenInfo.getFirst(), tokenInfo.getSecond())
                .map(user -> activityRepository.findById(request.getActivityId())
                        .map(activity -> attendanceRepository.findByActivityIdAndUserId(activity.getId(), user.getId())
                                .map(a -> "Already joined")
                                .orElseGet(() -> joinUser(user.getId(), activity.getId())))
                        .orElse("ERROR IN ACTIVITY ID"))
                .orElse("ERROR IN USER ID");
    }

    private String joinUser(Long userId, Long activityId) {
        attendanceRepository.save(Attendance.builder()
                .userId(userId)
                .activityId(activityId)
                .build());
        return "OK";
    }
}
