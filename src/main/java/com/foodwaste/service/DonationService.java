package com.foodwaste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwaste.entity.Donation;
import com.foodwaste.repository.DonationRepository;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

   

    // Get All Donations
    public List<Donation> getAllDonations() {

        return donationRepository.findAll();
    }

    // Get Donation By Id
    public Donation getDonationById(Long id) {

        return donationRepository
                .findById(id)
                .orElse(null);
    }

    public Donation saveDonation(Donation donation) {

        return donationRepository.save(donation);
    }
}

