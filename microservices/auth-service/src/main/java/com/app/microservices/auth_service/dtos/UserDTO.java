package com.app.microservices.auth_service.dtos;

import com.app.microservices.auth_service.entity.User;

public class UserDTO {
	public User toUser(RegisterRequest registerRequest){
		return new User(registerRequest.getUsername(), registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getRole());
	}
}
