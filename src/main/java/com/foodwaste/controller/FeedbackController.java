
package com.foodwaste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodwaste.entity.Feedback;
import com.foodwaste.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Save Feedback
    @PostMapping("/save")
    public ResponseEntity<Feedback>
    saveFeedback(
            @RequestBody Feedback feedback) {

        Feedback savedFeedback =
                feedbackService.saveFeedback(feedback);

        return ResponseEntity.ok(savedFeedback);
    }
}

