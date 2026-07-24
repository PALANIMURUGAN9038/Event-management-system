package com.eventmanagementsystem.eventmanagementsystem.repository;

import com.eventmanagementsystem.eventmanagementsystem.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    List<Feedback> findByEventID(Integer eventID);

    List<Feedback> findByUserID(Integer userID);
}