package com.example.tracker.controller;

import com.example.tracker.dto.DashboardResponse;
import com.example.tracker.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public DashboardResponse getDashboard(Principal principal) {
        return dashboardService.getDashboard(principal.getName());
    }
}
