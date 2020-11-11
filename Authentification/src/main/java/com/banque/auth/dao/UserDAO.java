package com.banque.auth.dao;

import java.util.List;

import com.banque.auth.entities.User;

public interface UserDAO {

	public User login(String email,String password);
	
	public void createProfile(User user);
	
	public List<User> getUsers();
	
}