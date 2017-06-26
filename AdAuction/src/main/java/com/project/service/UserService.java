package com.project.service;

import java.util.List;

import com.project.dto.Otpact;
import com.project.model.Otp;
import com.project.model.User;

public interface UserService {
	public User getUserDetails(String email);
	public User getUserDetails(int id);
	public void registerUser(User u);
	public void setActiveUser(String email);
	public boolean activateUser(Otpact ou);
	public void saveOtp(Otp otp);
	public void updateUser(User user);
	
}
