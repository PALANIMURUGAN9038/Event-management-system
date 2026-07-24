package com.eventmanagementsystem.eventmanagementsystem.service;

import com.eventmanagementsystem.eventmanagementsystem.entity.Notification;

import java.util.List;

public interface NotificationService {

    Notification createNotification(Notification notification);

    List<Notification> getAllNotifications();

    Notification getNotificationById(Integer id);

    List<Notification> getNotificationsByUser(Integer userID);

    void deleteNotification(Integer id);
}