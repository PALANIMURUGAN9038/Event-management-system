package com.eventmanagementsystem.eventmanagementsystem;

import com.eventmanagementsystem.eventmanagementsystem.entity.Notification;
import com.eventmanagementsystem.eventmanagementsystem.exception.ResourceNotFoundException;
import com.eventmanagementsystem.eventmanagementsystem.repository.NotificationRepository;
import com.eventmanagementsystem.eventmanagementsystem.service.NotificationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Mock
    private NotificationRepository repository;

    @InjectMocks
    private NotificationServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateNotification() {

        Notification notification =
                new Notification();

        notification.setNotificationID(1);
        notification.setUserID(1);
        notification.setEventID(1);
        notification.setMessage(
                "Event starts tomorrow");

        when(repository.save(any(Notification.class)))
                .thenReturn(notification);

        Notification result =
                service.createNotification(notification);

        assertEquals(
                "Event starts tomorrow",
                result.getMessage());
    }

    @Test
    void testGetNotificationById() {

        Notification notification =
                new Notification();

        notification.setNotificationID(1);
        notification.setMessage(
                "Event starts tomorrow");

        when(repository.findById(1))
                .thenReturn(
                        Optional.of(notification));

        Notification result =
                service.getNotificationById(1);

        assertEquals(
                "Event starts tomorrow",
                result.getMessage());
    }

    @Test
    void testNotificationNotFound() {

        when(repository.findById(100))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> service.getNotificationById(100));
    }

    @Test
    void testDeleteNotification() {

        doNothing().when(repository)
                .deleteById(1);

        service.deleteNotification(1);

        verify(repository,
                times(1))
                .deleteById(1);
    }
}