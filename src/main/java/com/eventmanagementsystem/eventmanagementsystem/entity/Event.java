package com.eventmanagementsystem.eventmanagementsystem.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventID;

    private String name;
    private String category;
    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Long organizerID;

    // Getters & Setters
    public Long getEventID() { return eventID; }
    public void setEventID(Long eventID) { this.eventID = eventID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Long getOrganizerID() { return organizerID; }
    public void setOrganizerID(Long organizerID) { this.organizerID = organizerID; }
}
