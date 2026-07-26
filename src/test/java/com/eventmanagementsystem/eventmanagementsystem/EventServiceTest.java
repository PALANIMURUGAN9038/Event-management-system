package com.eventmanagementsystem.eventmanagementsystem;

import com.eventmanagementsystem.eventmanagementsystem.entity.Event;
import com.eventmanagementsystem.eventmanagementsystem.exception.ResourceNotFoundException;
import com.eventmanagementsystem.eventmanagementsystem.repository.EventRepository;
import com.eventmanagementsystem.eventmanagementsystem.service.EventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EventServiceTest {

    @Mock
    private EventRepository repository;

    @InjectMocks
    private EventServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateEvent() {

        Event event = new Event();

        event.setEventID(1);
        event.setName("Music Concert");
        event.setCategory("Music");
        event.setLocation("Chennai");

        when(repository.save(event))
                .thenReturn(event);

        Event result =
                service.createEvent(event);

        assertEquals(
                "Music Concert",
                result.getName());
    }

    @Test
    void testGetEventById() {

        Event event = new Event();

        event.setEventID(1);
        event.setName("Music Concert");

        when(repository.findById(1))
                .thenReturn(Optional.of(event));

        Event result =
                service.getEventById(1);

        assertEquals(
                "Music Concert",
                result.getName());
    }

    @Test
    void testEventNotFound() {

        when(repository.findById(100))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> service.getEventById(100));
    }

    @Test
    void testUpdateEvent() {

        Event existing = new Event();

        existing.setEventID(1);
        existing.setName("Old Event");

        Event updated = new Event();

        updated.setName("New Event");
        updated.setCategory("Music");
        updated.setLocation("Chennai");

        when(repository.findById(1))
                .thenReturn(Optional.of(existing));

        when(repository.save(any(Event.class)))
                .thenReturn(existing);

        Event result =
                service.updateEvent(1, updated);

        assertEquals(
                "New Event",
                result.getName());
    }

    @Test
    void testDeleteEvent() {

        doNothing().when(repository)
                .deleteById(1);

        service.deleteEvent(1);

        verify(repository,
                times(1))
                .deleteById(1);
    }
}