package com.example.tracker.service;

import com.example.tracker.entity.User;
import com.example.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder
            encoder = new BCryptPasswordEncoder();

    public User register(User user) {user.setPassword(encoder.encode(user.getPassword()));
       return userRepository.save(user);
    }

    public String login(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (! encoder.matches(request.getPassword(),user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return "Login successful";
    }
}
