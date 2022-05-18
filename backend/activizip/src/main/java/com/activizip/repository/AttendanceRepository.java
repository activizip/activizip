package com.activizip.repository;

import com.activizip.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByActivityId(Long activityId);

    Optional<Attendance> findByActivityIdAndUserId(Long activityId, Long userId);
}
