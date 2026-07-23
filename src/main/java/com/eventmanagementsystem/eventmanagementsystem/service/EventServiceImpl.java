package com.eventmanagementsystem.eventmanagementsystem.service;

import com.eventmanagementsystem.eventmanagementsystem.entity.Event;
import com.eventmanagementsystem.eventmanagementsystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Event getEventById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Event updateEvent(Long id, Event event) {
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
    public void deleteEvent(Long id) {
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