package com.eventmanagementsystem.eventmanagementsystem.service;

import com.eventmanagementsystem.eventmanagementsystem.entity.Feedback;
import com.eventmanagementsystem.eventmanagementsystem.exception.ResourceNotFoundException;
import com.eventmanagementsystem.eventmanagementsystem.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    @Override
    public Feedback createFeedback(Feedback feedback) {

        feedback.setSubmittedTimestamp(new Date());

        return repository.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return repository.findAll();
    }

    @Override
    public Feedback getFeedbackById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Feedback Not Found"));
    }

    @Override
    public List<Feedback> getFeedbackByEvent(Integer eventID) {
        return repository.findByEventID(eventID);
    }

    @Override
    public List<Feedback> getFeedbackByUser(Integer userID) {
        return repository.findByUserID(userID);
    }

    @Override
    public void deleteFeedback(Integer id) {
        repository.deleteById(id);
    }
}