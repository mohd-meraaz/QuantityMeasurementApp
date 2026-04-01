package com.app.microservices.auth_service.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.microservices.auth_service.entity.User;
import com.app.microservices.auth_service.repository.UserRepository;

@Service
public class CustomUserDetailsService{

    private UserRepository repository;
    
    public CustomUserDetailsService(UserRepository repository) {
		this.repository = repository;
	}


	public UserDetails loadUserByEmail(String email) {

        User user = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}