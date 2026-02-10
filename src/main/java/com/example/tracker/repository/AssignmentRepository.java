package com.example.tracker.repository;

import com.example.tracker.entity.Assignment;
import com.example.tracker.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.example.tracker.entity.Status;
import java.time.LocalDate;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByCourse(Course course);
    long countByCourseUserEmail(String email);
    long countByCourseUserEmailAndStatus(String email, Status status);
    List<Assignment> findByCourseUserEmailAndDueDateBetween(
            String email,
            LocalDate start,
            LocalDate end
    );
}

