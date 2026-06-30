package com.foodwaste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodwaste.entity.Donation;
import com.foodwaste.entity.User;
import com.foodwaste.service.NgoService;

@RestController
@RequestMapping("/ngo")
public class NgoController {

    @Autowired
    private NgoService ngoService;

    // Accept Donation
    @PutMapping("/accept/{donationId}")
    public ResponseEntity<Donation>
    acceptDonation(
            @PathVariable Long donationId,
            @RequestBody User ngoUser) {

        Donation donation =
                ngoService.acceptDonation(
                        donationId,
                        ngoUser);

        return ResponseEntity.ok(donation);
    }

    // Collect Donation
    @PutMapping("/collect/{donationId}")
    public ResponseEntity<Donation>
    collectDonation(
            @PathVariable Long donationId) {

        Donation donation =
                ngoService.collectDonation(donationId);

        return ResponseEntity.ok(donation);
    }
}

