package com.banque.auth.service;

import java.util.List;

import com.banque.auth.controller.payload.response.UserResponse;
import com.banque.auth.entities.User;

public interface UserOTP {

	public UserResponse userProfileOTP(User user);
	
	public List<UserResponse> usersProfilesOTP(List<User> users);
}
