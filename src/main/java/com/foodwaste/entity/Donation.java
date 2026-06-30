package com.foodwaste.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "donations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodname;

    private String quantity;

    private String foodType;

    private LocalDateTime expiryTime;

    private String location;

    private String status;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private User donor;

    @ManyToOne
    @JoinColumn(name = "accepted_by")
    private User acceptedBy;

    @OneToMany(mappedBy = "donation", fetch = FetchType.EAGER)
    private List<Feedback> feedbacks;

    public Long getId() {
        return id;
    }

    public String getFoodname() {
        return foodname;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getFoodType() {
        return foodType;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public User getDonor() {
        return donor;
    }

    public User getAcceptedBy() {
        return acceptedBy;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDonor(User donor) {
        this.donor = donor;
    }

    public void setAcceptedBy(User acceptedBy) {
        this.acceptedBy = acceptedBy;
    }
}