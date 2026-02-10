package com.example.tracker.controller;

import com.example.tracker.entity.Assignment;
import com.example.tracker.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/{courseId}")
    public Assignment addAssignment(@PathVariable Long courseId, @RequestBody Assignment assignment) {

        return assignmentService.addAssignment(courseId, assignment);
    }

    @GetMapping("/{courseId}")
    public List<Assignment> getAssignments(@PathVariable Long courseId) {
        return assignmentService.getAssignmentsByCourse(courseId);
    }
}
