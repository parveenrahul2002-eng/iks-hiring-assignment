package com.example.tracker.controller;

import com.example.tracker.entity.Course;
import com.example.tracker.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course addCourse(@RequestBody Course course, Principal principal) {
        return courseService.addCourse(course, principal.getName());
    }

    @GetMapping
    public List<Course> getCourses(Principal principal) {
        return courseService.getCourses(principal.getName());
    }
}
