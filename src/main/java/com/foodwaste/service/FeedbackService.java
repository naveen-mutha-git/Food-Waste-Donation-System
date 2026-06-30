package com.foodwaste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwaste.entity.Donation;
import com.foodwaste.entity.Feedback;
import com.foodwaste.repository.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Save Feedback
    public Feedback saveFeedback(
            Feedback feedback) {

        return feedbackRepository.save(feedback);
    }

    // Get Feedback By Donation
    public List<Feedback> getFeedbackByDonation(
            Donation donation) {

        return feedbackRepository
                .findByDonation(donation);
    }

    // Get All Feedbacks
    public List<Feedback> getAllFeedbacks() {

        return feedbackRepository.findAll();

    }
}