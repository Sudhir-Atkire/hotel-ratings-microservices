package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Rating;
import com.example.demo.repository.RatingsRepository;
import com.example.demo.service.IRatingService;

@Service
public class RatingServiceImpl implements IRatingService {

	private final RatingsRepository ratingsRepository;

	
	
	public RatingServiceImpl(RatingsRepository ratingsRepository) {
		super();
		this.ratingsRepository = ratingsRepository;
	}

	@Override
	public Rating addRating(Rating rating) {

		return ratingsRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingsRepository.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(int userId) {
		return ratingsRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingsByHotelId(int hotelId) {
		return ratingsRepository.findByHotelId(hotelId);
	}

}
