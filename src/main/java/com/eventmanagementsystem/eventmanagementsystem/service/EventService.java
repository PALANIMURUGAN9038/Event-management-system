package com.eventmanagementsystem.eventmanagementsystem.service;

import com.eventmanagementsystem.eventmanagementsystem.entity.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    List<Event> getAllEvents();

    Event getEventById(Integer id);

    Event updateEvent(Integer id, Event event);

    void deleteEvent(Integer id);


    List<Event> getByCategory(String category);

    List<Event> getByLocation(String location);
}