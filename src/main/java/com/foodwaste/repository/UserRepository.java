package com.foodwaste.repository;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.foodwaste.entity.Role;
import com.foodwaste.entity.User;


public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    
    long countByRole(Role role);

}

