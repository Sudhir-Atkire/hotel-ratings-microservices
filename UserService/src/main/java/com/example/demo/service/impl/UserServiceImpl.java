package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(int userId) {
		return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found given ID  : "+userId));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {

		getUserById(user.getUserId());
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(int userId) {
		getUserById(userId);
		userRepository.deleteById(userId);
	}

}
