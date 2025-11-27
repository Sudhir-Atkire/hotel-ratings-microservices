package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Rating;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.external.service.HotelServiceClient;
import com.example.demo.external.service.RatingServiceClient;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private final UserRepository userRepository;
	private final RestTemplate restTemplate;
	private final HotelServiceClient hotelServiceClient;
	private final RatingServiceClient ratingServiceClient;


	public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate,
			HotelServiceClient hotelServiceClient, RatingServiceClient ratingServiceClient) {
		super();
		this.userRepository = userRepository;
		this.restTemplate = restTemplate;
		this.hotelServiceClient = hotelServiceClient;
		this.ratingServiceClient = ratingServiceClient;
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	// Rest Template
	/*
	@Override
	public User getUserById(int userId) {
		
		User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found given ID  : "+userId));
		String url = "http://RATINGSERVICE/ratings/users/"+user.getUserId();
		Rating[] ratingArrayr = restTemplate.getForObject(url, Rating[].class);
		
		List<Rating> ratingOfUser = Arrays.stream(ratingArrayr).toList();
		ratingOfUser.stream().map(rating->{
			// api call to get Hotel Service
//			localhost:8082/hotels/59
			
			ResponseEntity<Hotel> forEntity =  restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = forEntity.getBody();
			// set Hotel to Rating
			rating.setHotel(hotel); 
			//return the reating
			
			return rating;
		}).collect(Collectors.toList()); 
		
		user.setRatings(ratingOfUser);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
	    List<User> userList = 	userRepository.findAll();
	    
	    userList.forEach(user->{
	    	Rating[] r = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
	    	
	    List<Rating> ratings=Arrays.stream(r).toList().stream()
	    	.map(rating->{
	    	ResponseEntity<Hotel> forEntityObj=	restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
	    		Hotel hotel = forEntityObj.getBody();
	    		rating.setHotel(hotel);
	    		return rating;
	    	}).toList();
	    	
	    	user.setRatings(ratings);
	    });
	    
	    return userList;
	}

 */
	
	
	// Using Feign Client
	@Override
	public User getUserById(int userId) {
		User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found for given ID  : "+userId));
	
		List<Rating> ratingOfUser = ratingServiceClient.getRetings(user.getUserId());
		ratingOfUser.stream().map(rating->{
		
		Hotel hotel = hotelServiceClient.getHotel(rating.getHotelId());
		rating.setHotel(hotel); 
		
		return rating;
		}).collect(Collectors.toList()); 
	
		user.setRatings(ratingOfUser);
	
		return user;
	}
	
	//using Feign Client
	@Override
	public List<User> getAllUsers() {
		List<User> userList =	userRepository.findAll();
		
		userList.forEach(user->{
			List<Rating> ratings = ratingServiceClient.getRetings(user.getUserId());
			
			ratings.stream().map(rating->{
			Hotel hotel=	hotelServiceClient.getHotel(rating.getHotelId());
			rating.setHotel(hotel);	
			return rating;
			}).toList();
			
			user.setRatings(ratings);
		});
		
		return userList;
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
