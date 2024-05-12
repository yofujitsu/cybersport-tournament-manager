package com.example.veronika.service;

import com.example.veronika.entity.User;
import com.example.veronika.repos.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getAuthenticatedUser(String username) {
        // This should integrate with Spring Security to fetch the authenticated user
        return userRepository.findByUsername(username);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User authenticateUser(String username) {
        // This should be more complex with security considerations
        return userRepository.findByUsername(username);
    }

    public User updateUser(Long id, User userUpdates) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(userUpdates.getUsername());
            user.setEmail(userUpdates.getEmail());
            user.setPassword(userUpdates.getPassword()); // Normally you'd encrypt this
            userRepository.save(user);
        }
        return user;
    }
}

