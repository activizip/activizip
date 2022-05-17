package com.activizip.controller;

import com.activizip.model.Activity;
import com.activizip.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ActivityController {

    private ActivityService activityService;

    @GetMapping("/activities")
    public List<Activity> activities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/activities/{id}")
    public Activity activitiesById(@PathVariable long id) {
        return activityService.findById(id);
    }

}
