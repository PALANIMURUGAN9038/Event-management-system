package com.eventmanagementsystem.eventmanagementsystem.service;

import com.eventmanagementsystem.eventmanagementsystem.entity.Event;
import com.eventmanagementsystem.eventmanagementsystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventmanagementsystem.eventmanagementsystem.exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;

    @Override
    public Event createEvent(Event event) {
        return repository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public Event getEventById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Event Not Found"));
    }

    @Override
    public Event updateEvent(Integer id, Event event) {
        Event existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(event.getName());
            existing.setCategory(event.getCategory());
            existing.setLocation(event.getLocation());
            existing.setDate(event.getDate());
            existing.setOrganizerID(event.getOrganizerID());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteEvent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Event> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    @Override
    public List<Event> getByLocation(String location) {
        return repository.findByLocation(location);
    }
}