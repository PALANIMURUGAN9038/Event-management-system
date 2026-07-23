package com.eventmanagementsystem.eventmanagementsystem.service;

import com.eventmanagementsystem.eventmanagementsystem.entity.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    List<Event> getAllEvents();

    Event getEventById(Long id);

    Event updateEvent(Long id, Event event);

    void deleteEvent(Long id);

    List<Event> getByCategory(String category);

    List<Event> getByLocation(String location);
}