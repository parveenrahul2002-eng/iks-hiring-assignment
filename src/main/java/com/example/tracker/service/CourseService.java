package com.example.tracker.service;

import com.example.tracker.entity.Course;
import com.example.tracker.entity.User;
import com.example.tracker.repository.CourseRepository;
import com.example.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public Course addCourse(Course course, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        course.setUser(user);
        return courseRepository.save(course);
    }

    public List<Course> getCourses(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return courseRepository.findByUser(user);
    }
}
