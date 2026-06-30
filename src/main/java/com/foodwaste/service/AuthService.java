
package com.foodwaste.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.foodwaste.dto.RegisterRequest;
import com.foodwaste.entity.Role;
import com.foodwaste.entity.User;
import com.foodwaste.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    

    // Register User
    public User registerUser(RegisterRequest request) {
    	if(userRepository.findByEmail(request.getEmail()).isPresent()) {
    	    return null;
    	}
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Encrypt password
        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()));

        user.setRole(
                Role.valueOf(request.getRole()));

        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        return userRepository.save(user);
    }

    // Find User By Email
    public Optional<User> findByEmail(String email) {

        return userRepository.findByEmail(email);
    }
    public User loginUser(String email, String password) {

        Optional<User> optionalUser =
                userRepository.findByEmail(email);

        if(optionalUser.isPresent()) {

            User user = optionalUser.get();

            if(passwordEncoder.matches(
                    password,
                    user.getPassword())) {

                return user;
            }
        }

        return null;
    }
}

