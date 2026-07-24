package com.eventmanagementsystem.eventmanagementsystem.service;

import com.eventmanagementsystem.eventmanagementsystem.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    Feedback createFeedback(Feedback feedback);

    List<Feedback> getAllFeedbacks();

    Feedback getFeedbackById(Integer id);

    List<Feedback> getFeedbackByEvent(Integer eventID);

    List<Feedback> getFeedbackByUser(Integer userID);

    void deleteFeedback(Integer id);
}