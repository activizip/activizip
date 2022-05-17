package com.activizip.service;

import com.activizip.model.Activity;
import com.activizip.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActivityService {

    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity findById(long id) {
        return activityRepository.findById(id).get();
    }
}
