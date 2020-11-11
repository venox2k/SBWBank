package com.banque.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banque.auth.controller.payload.request.LoginRequest;
import com.banque.auth.controller.payload.request.UserRequest;
import com.banque.auth.controller.payload.response.UserResponse;
import com.banque.auth.dao.UserDAO;
import com.banque.auth.entities.User;
import com.banque.auth.exception.BadRequestException;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserPTO userPOT;
	@Autowired
	private UserOTP userOTP;

	public Boolean login(LoginRequest loginRequest) {
		Boolean authenticate=false;
		User user=userDAO.login(loginRequest.getEmail(), loginRequest.getPassword());
		if(user !=null)
			authenticate=true;
		return authenticate;
	}

	public UserResponse createProfile(UserRequest userRequest) {
		User user=userPOT.userProfilePTO(userRequest);
		userDAO.createProfile(user);
		UserResponse userResponse=userOTP.userProfileOTP(user);
		return userResponse;
	}

	public List<UserResponse> getUsers() throws BadRequestException {
		List<User> users=userDAO.getUsers();
		List<UserResponse> usersResponses=userOTP.usersProfilesOTP(users);
		if(usersResponses !=null)
			return usersResponses;
		else
			throw new BadRequestException("la liste des users est vide");
		
	}

}
