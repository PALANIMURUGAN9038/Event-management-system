package com.eventmanagementsystem.eventmanagementsystem.controller;

import com.eventmanagementsystem.eventmanagementsystem.entity.Event;
import com.eventmanagementsystem.eventmanagementsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
public class EventController {

    @Autowired
    private EventService service;

    // Create Event
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return service.createEvent(event);
    }

    // Get All Events
    @GetMapping
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }

    // Get Event by ID
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return service.getEventById(id);
    }

    // Update Event
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return service.updateEvent(id, event);
    }

    // Delete Event
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
        return "Event deleted successfully";
    }

    // Filter by Category
    @GetMapping("/category/{category}")
    public List<Event> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    // Filter by Location
    @GetMapping("/location/{location}")
    public List<Event> getByLocation(@PathVariable String location) {
        return service.getByLocation(location);
    }
}