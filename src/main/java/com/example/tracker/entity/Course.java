package com.example.tracker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseTitle;
    private String courseCode;
    private String instructorName;
    private int credits;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
