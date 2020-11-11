package com.banque.auth.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.banque.auth.controller.payload.request.UserRequest;
import com.banque.auth.entities.User;

@Service
public class UserPTOImpl implements UserPTO {

	public User userProfilePTO(UserRequest userRequest) {
		User user=new User();
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		user.setUuid(userRequest.getUuid());
		user.setName(userRequest.getName());
		user.setPhone(userRequest.getPhone());
		user.setEmail(userRequest.getEmail());
		user.setGender(userRequest.getGender());
		user.setDob(userRequest.getDob());
		
		user.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
		user.setEid(userRequest.getEid());
		
		return user;
	}

}
