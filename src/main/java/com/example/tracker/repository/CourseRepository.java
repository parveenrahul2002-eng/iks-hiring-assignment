package com.example.tracker.repository;

import com.example.tracker.entity.Course;
import com.example.tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findByUser(User user);
}
