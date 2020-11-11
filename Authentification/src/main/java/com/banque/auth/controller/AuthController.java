package com.banque.auth.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banque.auth.controller.payload.request.LoginRequest;
import com.banque.auth.controller.payload.request.UserRequest;
import com.banque.auth.controller.payload.response.UserResponse;
import com.banque.auth.service.UserService;


@RestController
@RequestMapping("/api/user")
public class AuthController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
		try {
			Boolean authenticate = userService.login(loginRequest);
			return new ResponseEntity<Object>(authenticate,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createProfile(@Valid @RequestBody UserRequest userRequest) {
		try {
			UserResponse userResponse = userService.createProfile(userRequest);
			return new ResponseEntity<Object>(userResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<?> getUsers() {
		try {
			List<UserResponse> users=userService.getUsers();
			return new ResponseEntity<Object>(users,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

}
