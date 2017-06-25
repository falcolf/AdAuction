package com.project.dao;

import java.util.List;

import com.project.model.User;

public interface UserDao {
	User findById(int id);
	User findByEmail(String email);
	void regUser(User user);
	void setActiveUser(String email);
	void deleteUser(String email);
	List<User> getAllUsers();
}
