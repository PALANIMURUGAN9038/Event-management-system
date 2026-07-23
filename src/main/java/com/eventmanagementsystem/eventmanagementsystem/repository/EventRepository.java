package com.eventmanagementsystem.eventmanagementsystem.repository;

import com.eventmanagementsystem.eventmanagementsystem.entity.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByCategory(String category);
    List<Event> findByLocation(String location);
}