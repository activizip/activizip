package com.activizip.repository;

import com.activizip.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByDateGreaterThan(LocalDate localDate);

    //List<Activity> findByNameContainingIgnoreCase(String name);

    @Query("SELECT a FROM Activity a WHERE a.name LIKE %:name%")
    List<Activity> findByNameContainingIgnoreCase(@Param("name") String name);
}
