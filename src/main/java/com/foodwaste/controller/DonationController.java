
package com.foodwaste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodwaste.entity.Donation;
import com.foodwaste.service.DonationService;

@RestController
@RequestMapping("/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    // Add Donation
    @PostMapping("/save")
    public ResponseEntity<Donation> saveDonation(
            @RequestBody Donation donation) {

        Donation savedDonation =
                donationService.saveDonation(donation);

        return ResponseEntity.ok(savedDonation);
    }

    // Get All Donations
    @GetMapping("/all")
    public ResponseEntity<List<Donation>>
    getAllDonations() {

        return ResponseEntity.ok(
                donationService.getAllDonations());
    }

    // Get Donation By Id
    @GetMapping("/{id}")
    public ResponseEntity<Donation>
    getDonationById(
            @PathVariable Long id) {

        Donation donation =
                donationService.getDonationById(id);

        return ResponseEntity.ok(donation);
    }
}

