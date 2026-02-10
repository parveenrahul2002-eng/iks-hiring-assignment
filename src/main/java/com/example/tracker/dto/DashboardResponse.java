package com.example.tracker.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {

    private long totalAssignments;
    private long completedAssignments;
    private long pendingAssignments;
    private double progressPercentage;
    private List<String> upcomingAssignments;
}
