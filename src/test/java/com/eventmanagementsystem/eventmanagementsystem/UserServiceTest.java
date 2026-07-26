package com.eventmanagementsystem.eventmanagementsystem;

import com.eventmanagementsystem.eventmanagementsystem.entity.User;
import com.eventmanagementsystem.eventmanagementsystem.exception.ResourceNotFoundException;
import com.eventmanagementsystem.eventmanagementsystem.repository.UserRepository;
import com.eventmanagementsystem.eventmanagementsystem.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {

        User user = new User();

        user.setUserID(1);
        user.setName("Palani");
        user.setEmail("palani@gmail.com");
        user.setPassword("12345");

        when(passwordEncoder.encode("12345"))
                .thenReturn("encryptedPassword");

        when(repository.save(any(User.class)))
                .thenReturn(user);

        User result = service.createUser(user);

        assertEquals(
                "Palani",
                result.getName());
    }

    @Test
    void testGetUserById() {

        User user = new User();

        user.setUserID(1);
        user.setName("Palani");

        when(repository.findById(1))
                .thenReturn(Optional.of(user));

        User result = service.getUserById(1);

        assertEquals(
                "Palani",
                result.getName());
    }

    @Test
    void testUserNotFound() {

        when(repository.findById(100))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> service.getUserById(100));
    }

    @Test
    void testUpdateUser() {

        User existing = new User();

        existing.setUserID(1);
        existing.setName("Old User");

        User updated = new User();

        updated.setName("New User");
        updated.setEmail("new@gmail.com");
        updated.setPassword("12345");
        updated.setContactNumber("9876543210");

        when(repository.findById(1))
                .thenReturn(Optional.of(existing));

        when(passwordEncoder.encode("12345"))
                .thenReturn("encryptedPassword");

        when(repository.save(any(User.class)))
                .thenReturn(existing);

        User result =
                service.updateUser(1, updated);

        assertEquals(
                "New User",
                result.getName());
    }

    @Test
    void testDeleteUser() {

        User user = new User();
        user.setUserID(1);

        when(repository.findById(1))
                .thenReturn(Optional.of(user));

        service.deleteUser(1);

        verify(repository,
                times(1))
                .deleteById(1);
    }

    @Test
    void testLoginSuccess() {

        User user = new User();

        user.setEmail("palani@gmail.com");
        user.setPassword("encryptedPassword");

        when(repository.findByEmail(
                "palani@gmail.com"))
                .thenReturn(Optional.of(user));

        when(passwordEncoder.matches(
                "12345",
                "encryptedPassword"))
                .thenReturn(true);

        User result =
                service.login(
                        "palani@gmail.com",
                        "12345");

        assertEquals(
                "palani@gmail.com",
                result.getEmail());
    }

    @Test
    void testInvalidEmail() {

        when(repository.findByEmail(
                "invalid@gmail.com"))
                .thenReturn(Optional.empty());

        assertThrows(
                RuntimeException.class,
                () -> service.login(
                        "invalid@gmail.com",
                        "12345"));
    }

    @Test
    void testInvalidPassword() {

        User user = new User();

        user.setEmail("palani@gmail.com");
        user.setPassword("encryptedPassword");

        when(repository.findByEmail(
                "palani@gmail.com"))
                .thenReturn(Optional.of(user));

        when(passwordEncoder.matches(
                "wrongpassword",
                "encryptedPassword"))
                .thenReturn(false);

        assertThrows(
                RuntimeException.class,
                () -> service.login(
                        "palani@gmail.com",
                        "wrongpassword"));
    }
}