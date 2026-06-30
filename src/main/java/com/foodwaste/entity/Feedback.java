
package com.foodwaste.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating;

    private String comments;

    @ManyToOne
    @JoinColumn(name = "donation_id")
    private Donation donation;

  
    @ManyToOne
    @JoinColumn(name = "ngo_id")
    private User ngo;


	public Long getId() {
		return id;
	}


	public Integer getRating() {
		return rating;
	}


	public String getComments() {
		return comments;
	}


	public Donation getDonation() {
		return donation;
	}


	public User getNgo() {
		return ngo;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public void setDonation(Donation donation) {
		this.donation = donation;
	}


	public void setNgo(User ngo) {
		this.ngo = ngo;
	}
    
   

       

       
}

