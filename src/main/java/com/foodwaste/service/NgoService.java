package com.foodwaste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwaste.entity.Donation;
import com.foodwaste.entity.User;
import com.foodwaste.repository.DonationRepository;

@Service
public class NgoService {

    @Autowired
    private DonationRepository donationRepository;

    // Accept Donation
    public Donation acceptDonation(
            Long donationId,
            User ngoUser) {

        Donation donation =
                donationRepository.findById(donationId)
                        .orElse(null);

        if(donation != null) {

            donation.setAcceptedBy(ngoUser);

            donation.setStatus("ACCEPTED");

            return donationRepository.save(donation);
        }

        return null;
    }

    // Mark Donation Collected
    public Donation collectDonation(Long donationId) {

        Donation donation =
                donationRepository.findById(donationId)
                        .orElse(null);

        if(donation != null) {

            donation.setStatus("COLLECTED");

            return donationRepository.save(donation);
        }

        return null;
    }
}

