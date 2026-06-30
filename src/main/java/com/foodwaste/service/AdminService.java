package com.foodwaste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwaste.entity.Donation;
import com.foodwaste.entity.User;
import com.foodwaste.repository.DonationRepository;
import com.foodwaste.repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonationRepository donationRepository;

    // Get All Users
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    // Get All Donations
    public List<Donation> getAllDonations() {

        return donationRepository.findAll();
    }
}
