package com.eventmanagementsystem.eventmanagementsystem.controller;

import com.eventmanagementsystem.eventmanagementsystem.entity.Feedback;
import com.eventmanagementsystem.eventmanagementsystem.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin("*")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return service.createFeedback(feedback);
    }

    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return service.getAllFeedbacks();
    }

    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable Integer id) {
        return service.getFeedbackById(id);
    }

    @GetMapping("/event/{eventID}")
    public List<Feedback> getFeedbackByEvent(
            @PathVariable Integer eventID) {

        return service.getFeedbackByEvent(eventID);
    }

    @GetMapping("/user/{userID}")
    public List<Feedback> getFeedbackByUser(
            @PathVariable Integer userID) {

        return service.getFeedbackByUser(userID);
    }

    @DeleteMapping("/{id}")
    public String deleteFeedback(@PathVariable Integer id) {

        service.deleteFeedback(id);

        return "Feedback deleted successfully";
    }
}