package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Rating;

public interface IRatingService {

	Rating addRating(Rating rating);
	
	List<Rating> getAllRatings();
	
	List<Rating> getRatingsByUserId(int userId);
	
	List<Rating> getRatingsByHotelId(int hotelId);
}
