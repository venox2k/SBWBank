package com.banque.auth.service;

import com.banque.auth.controller.payload.request.UserRequest;
import com.banque.auth.entities.User;

public interface UserPTO {

	public User userProfilePTO(UserRequest userPayload);
}
