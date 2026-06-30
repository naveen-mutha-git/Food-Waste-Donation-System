package com.foodwaste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodwaste.entity.Donation;
import com.foodwaste.entity.User;
import com.foodwaste.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Get All Users
    @GetMapping("/users")
    public ResponseEntity<List<User>>
    getAllUsers() {

        return ResponseEntity.ok(
                adminService.getAllUsers());
    }

    // Get All Donations
    @GetMapping("/donations")
    public ResponseEntity<List<Donation>>
    getAllDonations() {

        return ResponseEntity.ok(
                adminService.getAllDonations());
    }
}

