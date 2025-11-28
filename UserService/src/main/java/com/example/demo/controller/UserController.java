package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);
	private final IUserService userService;
	
	
	public UserController(IUserService userService) {
		super();
		this.userService = userService;
	}



	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		User u = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
	}
	
	@GetMapping("/{userId}")
	@CircuitBreaker(name="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId){
		
		return ResponseEntity.ok(userService.getUserById(userId));
	}
	
	
	public ResponseEntity<User> ratingHotelFallback(Integer userid, Exception ex){
		log.info("ratingHOtelFallback : Fallback Method executed because service is down : "+ex.getMessage());
	User user=User
		.builder()
		.userEmail("dummyEmail")
		.userMno("999909999")
		.userGender("dummy")
		.userName("Dummy Name")
		.build();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	// update User 
    	
	// delete User
}
