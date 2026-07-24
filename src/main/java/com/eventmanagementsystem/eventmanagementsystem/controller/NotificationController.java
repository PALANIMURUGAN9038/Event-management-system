package com.eventmanagementsystem.eventmanagementsystem.controller;
import com.eventmanagementsystem.eventmanagementsystem.service.NotificationService;
import com.eventmanagementsystem.eventmanagementsystem.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping
    public Notification createNotification(
            @RequestBody Notification notification) {

        return service.createNotification(notification);
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return service.getAllNotifications();
    }

    @GetMapping("/{id}")
    public Notification getNotification(
            @PathVariable Integer id) {

        return service.getNotificationById(id);
    }

    @GetMapping("/user/{userID}")
    public List<Notification> getByUser(
            @PathVariable Integer userID) {

        return service.getNotificationsByUser(userID);
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(
            @PathVariable Integer id) {

        service.deleteNotification(id);

        return "Notification Deleted Successfully";
    }
}