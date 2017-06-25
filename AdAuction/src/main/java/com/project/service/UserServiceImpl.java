package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.OtpDaoImpl;
import com.project.dao.UserDaoImpl;
import com.project.dto.Otpact;
import com.project.model.Otp;
import com.project.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDaoImpl dao;
	@Autowired
	private OtpDaoImpl dao2;
	
	@Override
	public User getUserDetails(String email) {
		User u=dao.findByEmail(email);
		return u;
	}

	@Override
	@Transactional
	public void registerUser(User u) {
		dao.regUser(u);
		
	}

	@Override
	public void setActiveUser(String email) {
		 dao.setActiveUser(email);
		
	}
	
	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public boolean activateUser(Otpact ou) {
		
		return dao2.activateUser(ou);
	}

	@Override
	public void saveOtp(Otp otp) {
		dao2.saveOtp(otp);
		
	}

	@Override
	public User getUserDetails(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	
	
}
