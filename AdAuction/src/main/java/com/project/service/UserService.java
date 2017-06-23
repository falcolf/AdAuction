package com.project.service;

import java.util.List;

import com.project.model.User;

public interface UserService {
	public User getUserDetails(String email);
	public void registerUser(User u);
	public void activateUser(String email);
	
	public List<User> getAllUsers();
}
