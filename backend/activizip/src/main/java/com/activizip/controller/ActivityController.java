package com.activizip.controller;

import com.activizip.model.dto.ActivityRequestDTO;
import com.activizip.model.dto.ActivityResponseDTO;
import com.activizip.model.dto.ResponseDTO;
import com.activizip.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/activities")
public class ActivityController {

    private ActivityService activityService;

    @GetMapping
    public List<ActivityResponseDTO> allActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/{id}")
    public ActivityResponseDTO activity(@PathVariable long id) {
        return activityService.getActivity(id);
    }

    @GetMapping("/search")
    public List<ActivityResponseDTO> activity(@RequestParam String term) {
        return activityService.searchActivities(term);
    }

    @PostMapping
    public ResponseDTO newActivity(@RequestBody ActivityRequestDTO request) {
        return ResponseDTO.builder().response(activityService.createActivity(request)).build();
    }

}
