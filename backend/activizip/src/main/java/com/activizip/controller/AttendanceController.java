package com.activizip.controller;

import com.activizip.model.dto.JoinRequestDTO;
import com.activizip.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/attendance")
public class AttendanceController {

    private AttendanceService attendanceService;

    @PostMapping("/join")
    public String join(@RequestBody JoinRequestDTO request) {
        return attendanceService.join(request);
    }

}
