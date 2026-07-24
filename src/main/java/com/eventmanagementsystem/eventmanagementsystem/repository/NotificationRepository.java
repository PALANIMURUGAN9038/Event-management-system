package com.eventmanagementsystem.eventmanagementsystem.repository;

import com.eventmanagementsystem.eventmanagementsystem.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository
        extends JpaRepository<Notification, Integer> {

    List<Notification> findByUserID(Integer userID);

    List<Notification> findByEventID(Integer eventID);
}