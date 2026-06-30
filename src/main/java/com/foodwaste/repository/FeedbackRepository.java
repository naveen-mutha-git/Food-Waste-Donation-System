
package com.foodwaste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodwaste.entity.Donation;
import com.foodwaste.entity.Feedback;

public interface FeedbackRepository
        extends JpaRepository<Feedback, Long> {

    List<Feedback> findByDonation(Donation donation);

}
