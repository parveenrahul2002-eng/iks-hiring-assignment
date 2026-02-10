package com.example.tracker.entity;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
