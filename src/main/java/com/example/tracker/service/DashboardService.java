package com.example.tracker.service;
import com.example.tracker.dto.DashboardResponse;
import com.example.tracker.entity.Assignment;
import com.example.tracker.entity.Status;
import com.example.tracker.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public DashboardResponse getDashboard(String email) {

        long total = assignmentRepository.countByCourseUserEmail(email);
        long completed = assignmentRepository.countByCourseUserEmailAndStatus(
                email, Status.COMPLETED);
        long pending = total - completed;
        double progress = total == 0 ? 0 : (completed * 100.0) / total;
        LocalDate now = LocalDate.now();
        List<String> upcoming = assignmentRepository.findByCourseUserEmailAndDueDateBetween(email, now, now.plusDays(3))
                .stream()
                .map(a -> a.getTitle() + " (Due: " + a.getDueDate() + ")")
                .collect(Collectors.toList());
        return new DashboardResponse(
                total,
                completed,
                pending,
                Math.round(progress * 100.0) / 100.0,
                upcoming
        );
    }
}

