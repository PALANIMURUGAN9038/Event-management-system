package com.eventmanagementsystem.eventmanagementsystem;

import com.eventmanagementsystem.eventmanagementsystem.entity.Feedback;
import com.eventmanagementsystem.eventmanagementsystem.exception.ResourceNotFoundException;
import com.eventmanagementsystem.eventmanagementsystem.repository.FeedbackRepository;
import com.eventmanagementsystem.eventmanagementsystem.service.FeedbackServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FeedbackServiceTest {

    @Mock
    private FeedbackRepository repository;

    @InjectMocks
    private FeedbackServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateFeedback() {

        Feedback feedback = new Feedback();

        feedback.setFeedbackID(1);
        feedback.setEventID(1);
        feedback.setUserID(1);
        feedback.setRating(5);
        feedback.setComments("Excellent Event");

        when(repository.save(any(Feedback.class)))
                .thenReturn(feedback);

        Feedback result =
                service.createFeedback(feedback);

        assertEquals(
                "Excellent Event",
                result.getComments());
    }

    @Test
    void testGetFeedbackById() {

        Feedback feedback = new Feedback();

        feedback.setFeedbackID(1);
        feedback.setComments(
                "Excellent Event");

        when(repository.findById(1))
                .thenReturn(
                        Optional.of(feedback));

        Feedback result =
                service.getFeedbackById(1);

        assertEquals(
                "Excellent Event",
                result.getComments());
    }

    @Test
    void testFeedbackNotFound() {

        when(repository.findById(100))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> service.getFeedbackById(100));
    }

    @Test
    void testDeleteFeedback() {

        doNothing().when(repository)
                .deleteById(1);

        service.deleteFeedback(1);

        verify(repository,
                times(1))
                .deleteById(1);
    }
}