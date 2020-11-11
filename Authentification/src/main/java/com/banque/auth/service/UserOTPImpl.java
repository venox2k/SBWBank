package com.banque.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banque.auth.controller.payload.response.UserResponse;
import com.banque.auth.entities.User;
@Service
public class UserOTPImpl implements UserOTP {

	public UserResponse userProfileOTP(User user) {
		UserResponse userResponse=new UserResponse();
		userResponse.setUuid(user.getUuid());
		userResponse.setDob(user.getDob());
		userResponse.setEid(user.getEid());
		userResponse.setEmail(user.getEmail());
		userResponse.setGender(user.getGender());
		userResponse.setName(user.getName());
		userResponse.setPhone(user.getPhone());
		return userResponse;
	}

	public List<UserResponse> usersProfilesOTP(List<User> users) {
		List<UserResponse> usersResponse=null;
		if(users!=null) {
			usersResponse=new ArrayList<UserResponse>();
			for (User user : users) {
				UserResponse userResponse=userProfileOTP(user);
				usersResponse.add(userResponse);
			}
			return usersResponse;
		}
		return null;
	}

}
