package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.UserDaoImpl;
import com.project.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDaoImpl dao;
	
	@Override
	public User getUserDetails(String email) {
		User u=dao.findByEmail(email);
		return u;
	}

	@Override
	public void registerUser(User u) {
		dao.regUser(u);
		
	}

	@Override
	public void activateUser(String email) {
		dao.activateUser(email);
		
	}
	
	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	
	
}
