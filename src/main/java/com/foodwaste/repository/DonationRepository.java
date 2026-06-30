
package com.foodwaste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodwaste.entity.Donation;
import com.foodwaste.entity.Role;
import com.foodwaste.entity.User;

public interface DonationRepository
        extends JpaRepository<Donation, Long> {

    List<Donation> findByDonor(User donor);

    List<Donation> findByStatus(String status);
    
    long countByStatus(String status);
    
    

}

