package com.app.microservices.auth_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservices.auth_service.dtos.AuthResponse;
import com.app.microservices.auth_service.service.GoogleAuthService;

@RestController
@RequestMapping("/auth/google")
public class GoogleAuthController {
	
	private GoogleAuthService googleAuthService;
	
	public GoogleAuthController(GoogleAuthService googleAuthService) {
		this.googleAuthService = googleAuthService;
	}

	@GetMapping("/callback")
	public ResponseEntity<AuthResponse> handleGoogleCallback(@RequestParam String code){
		return ResponseEntity.ok(googleAuthService.handleGoogleAuth(code));
	}
}