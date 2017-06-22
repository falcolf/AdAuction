package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.UserDao;
import com.project.model.User;

@Service("userService")
@Transactional
public class UserService {
	@Autowired
	private UserDao dao;
	
	public User getUserDetails(String email){
		User u=dao.getByEmail(email);
		return u;
	}
	public void registerUser(User u){
		dao.regUser(u);
	}
	public void activateUser(String email){
		dao.activateUser(email);
	}
	public void updateEmail(String nemail , String oemail){
		dao.updateEmail(oemail, nemail);
	}
	public List<User> getAllUsers(){
		return dao.getAllUsers();
	}
}
