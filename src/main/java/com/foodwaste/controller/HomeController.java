package com.foodwaste.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.foodwaste.dto.LoginRequest;
import com.foodwaste.dto.RegisterRequest;
import com.foodwaste.entity.Donation;
import com.foodwaste.entity.Feedback;
import com.foodwaste.entity.Role;
import com.foodwaste.entity.User;
import com.foodwaste.repository.DonationRepository;
import com.foodwaste.repository.UserRepository;
import com.foodwaste.service.AuthService;
import com.foodwaste.service.DonationService;
import com.foodwaste.service.FeedbackService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private AuthService authService;

    @Autowired
    private DonationService donationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonationRepository donationRepository;
     
    @Autowired
    private FeedbackService feedbackService;

    // Home Page
    @GetMapping("/")
    public String home() {
        return "login";
    }

    // Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Register Page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // Login User
    @PostMapping("/login-user")
    public String loginUser(
            LoginRequest request,
            HttpSession session) {

        User user = authService.loginUser(
                request.getEmail(),
                request.getPassword());

        if (user == null) {
            return "redirect:/login";
        }

        session.setAttribute(
                "loggedInUser",
                user);

        if (user.getRole() == Role.DONOR) {
            return "redirect:/donor-dashboard";
        }

        if (user.getRole() == Role.NGO) {
            return "redirect:/ngo-dashboard";
        }

        if (user.getRole() == Role.ADMIN) {
            return "redirect:/admin-dashboard";
        }

        return "redirect:/login";
    }

    // Register User
    @PostMapping("/register-user")
    public String registerUser(RegisterRequest request) {

        authService.registerUser(request);

        return "redirect:/login";
    }

   
 
 // Donor Dashboard
    @GetMapping("/donor-dashboard")
    public String donorDashboard(
            Model model,
            HttpSession session) {

        User donor =
                (User) session.getAttribute("loggedInUser");

        if (donor == null) {
            return "redirect:/login";
        }

        List<Donation> donations =
                donationService.getAllDonations();

        long totalDonations =
                donations.size();

        long acceptedDonations =
                donations.stream()
                        .filter(d ->
                                "ACCEPTED".equals(d.getStatus()))
                        .count();

        long collectedDonations =
                donations.stream()
                        .filter(d ->
                                "COLLECTED".equals(d.getStatus()))
                        .count();

        long feedbackCount =
                donations.stream()
                        .filter(d ->
                                d.getFeedbacks() != null &&
                                !d.getFeedbacks().isEmpty())
                        .count();

        model.addAttribute(
                "donations",
                donations);

        model.addAttribute(
                "totalDonations",
                totalDonations);

        model.addAttribute(
                "acceptedDonations",
                acceptedDonations);

        model.addAttribute(
                "collectedDonations",
                collectedDonations);

        model.addAttribute(
                "feedbackCount",
                feedbackCount);

        // Recent Feedbacks
        List<Feedback> feedbacks =
                feedbackService.getAllFeedbacks();

        model.addAttribute(
                "feedbacks",
                feedbacks);

        // Logged in donor
        model.addAttribute(
                "loggedInUser",
                donor);

        return "donor-dashboard";
    }

    // NGO Dashboard
    @GetMapping("/ngo-dashboard")
    public String ngoDashboard(
            Model model,
            HttpSession session) {

        User ngo =
                (User) session.getAttribute("loggedInUser");

        if (ngo == null) {
            return "redirect:/login";
        }

        List<Donation> donations =
                donationService.getAllDonations();

        long availableCount =
                donations.stream()
                        .filter(d -> "AVAILABLE".equals(d.getStatus()))
                        .count();

        long acceptedCount =
                donations.stream()
                        .filter(d -> "ACCEPTED".equals(d.getStatus()))
                        .count();

        long collectedCount =
                donations.stream()
                        .filter(d -> "COLLECTED".equals(d.getStatus()))
                        .count();

        model.addAttribute("loggedInUser", ngo);

        model.addAttribute("donations", donations);

        model.addAttribute("availableCount", availableCount);

        model.addAttribute("acceptedCount", acceptedCount);

        model.addAttribute("collectedCount", collectedCount);
        model.addAttribute(
                "acceptedCount",
                donationService.getAllDonations()
                        .stream()
                        .filter(d -> "ACCEPTED".equals(d.getStatus()))
                        .count());

        model.addAttribute(
                "collectedCount",
                donationService.getAllDonations()
                        .stream()
                        .filter(d -> "COLLECTED".equals(d.getStatus()))
                        .count());

        model.addAttribute(
                "feedbackCount",
                feedbackService.getAllFeedbacks().size());

        return "ngo-dashboard";
    }
    // Admin Dashboard
    @GetMapping("/admin-dashboard")
    public String adminDashboard(Model model) {

        model.addAttribute(
                "totalUsers",
                userRepository.count());

        model.addAttribute(
                "totalDonors",
                userRepository.countByRole(Role.DONOR));

        model.addAttribute(
                "totalNgos",
                userRepository.countByRole(Role.NGO));

        model.addAttribute(
                "totalDonations",
                donationRepository.count());

        model.addAttribute(
                "acceptedDonations",
                donationRepository.countByStatus("ACCEPTED"));

        model.addAttribute(
                "collectedDonations",
                donationRepository.countByStatus("COLLECTED"));

        return "admin-dashboard";
    }

    // Add Donation Page
    @GetMapping("/add-donation")
    public String addDonationPage() {
        return "add-donation";
    }

    // Save Donation
    @PostMapping("/save-donation")
    public String saveDonation(
            Donation donation,
            HttpSession session) {

        User loggedInUser =
                (User) session.getAttribute("loggedInUser");

        if(loggedInUser == null ||
           loggedInUser.getRole() != Role.DONOR) {

            return "redirect:/login";
        }

        donation.setDonor(loggedInUser);

        donation.setStatus("AVAILABLE");

        donationService.saveDonation(donation);

        return "redirect:/donor-dashboard";
    }

    // Accept Donation
    @PostMapping("/accept-donation/{id}")
    public String acceptDonation(
            @PathVariable Long id,
            HttpSession session) {

        User ngoUser =
                (User) session.getAttribute("loggedInUser");

        Donation donation =
                donationService.getDonationById(id);

        if (donation == null) {
            return "redirect:/ngo-dashboard";
        }

        // Prevent multiple NGOs from accepting
        if (donation.getAcceptedBy() != null) {
            return "redirect:/ngo-dashboard";
        }

        donation.setStatus("ACCEPTED");
        donation.setAcceptedBy(ngoUser);

        donationService.saveDonation(donation);

        return "redirect:/ngo-dashboard";
    }
    // Collect Donation
    @PostMapping("/collect-donation/{id}")
    public String collectDonation(
            @PathVariable Long id) {

        Donation donation =
                donationService.getDonationById(id);

        if (donation != null) {

            donation.setStatus("COLLECTED");

            donationService.saveDonation(donation);
        }

        return "redirect:/ngo-dashboard";
    }

    // Feedback Page
    @GetMapping("/feedback")
    public String feedbackPage() {
        return "feedback";
    }
    @PostMapping("/save-feedback")
    public String saveFeedback(
            Long donationId,
            Integer rating,
            String comment) {

        Donation donation =
                donationService.getDonationById(
                        donationId);

        Feedback feedback =
                new Feedback();

        feedback.setDonation(donation);
        feedback.setRating(rating);
        feedback.setComments(comment);

        feedbackService.saveFeedback(feedback);

        return "redirect:/ngo-dashboard";
    }
    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}

