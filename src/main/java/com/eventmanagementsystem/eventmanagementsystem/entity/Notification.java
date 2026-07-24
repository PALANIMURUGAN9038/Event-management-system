package com.eventmanagementsystem.eventmanagementsystem.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NotificationID")
    private Integer notificationID;

    @Column(name = "UserID")
    private Integer userID;

    @Column(name = "EventID")
    private Integer eventID;

    @Column(name = "Message", columnDefinition = "TEXT")
    private String message;

    @Column(name = "SentTimestamp")
    private LocalDateTime sentTimestamp;

    public Notification() {}

    public Integer getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(Integer notificationID) {
        this.notificationID = notificationID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentTimestamp() {
        return sentTimestamp;
    }

    public void setSentTimestamp(LocalDateTime sentTimestamp) {
        this.sentTimestamp = sentTimestamp;
    }
}