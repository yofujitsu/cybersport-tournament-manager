package com.example.veronika;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.veronika.entity.User;
import com.example.veronika.repos.UserRepository;
import com.example.veronika.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserById() {
        User mockUser = new User();
        mockUser.setUserId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        User result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getUserId());
    }

    @Test
    public void testUpdateUser() {
        User existingUser = new User();
        existingUser.setUserId(1L);
        existingUser.setUsername("fuji");

        User updates = new User();
        updates.setUsername("new");

        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(existingUser);

        User updatedUser = userService.updateUser(1L, updates);
        assertNotNull(updatedUser);
        assertEquals("new", updatedUser.getUsername());
    }

    @Test
    public void testAuthenticateUser() {
        String username = "user";
        User foundUser = new User();
        foundUser.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(foundUser);

        User result = userService.authenticateUser(username);
        assertNotNull(result);
        assertEquals(username, result.getUsername());
    }
}

