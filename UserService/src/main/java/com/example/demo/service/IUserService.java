package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface IUserService {

	User addUser(User user);
	
	User getUserById(int userId);
	
	List<User> getAllUsers();
	
	User updateUser(User user);
	
	void deleteUser(int userId);
}
