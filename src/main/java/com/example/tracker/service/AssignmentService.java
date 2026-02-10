package com.example.tracker.service;

import com.example.tracker.entity.Assignment;
import com.example.tracker.entity.Course;
import com.example.tracker.repository.AssignmentRepository;
import com.example.tracker.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;
    private CourseRepository courseRepository;

    public Assignment addAssignment(Long courseId, Assignment assignment) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        assignment.setCourse(course);
        assignment.setStatus(assignment.getStatus() == null
                ?
                com.example.tracker.entity.Status.TODO
                : assignment.getStatus());
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAssignmentsByCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return assignmentRepository.findByCourse(course);

    }
}
