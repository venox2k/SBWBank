package com.banque.auth.service;

import java.util.List;

import com.banque.auth.controller.payload.request.LoginRequest;
import com.banque.auth.controller.payload.request.UserRequest;
import com.banque.auth.controller.payload.response.UserResponse;

public interface UserService {

	public Boolean login(LoginRequest loginRequest);

	public UserResponse createProfile(UserRequest userRequest);

	public List<UserResponse> getUsers();
}
