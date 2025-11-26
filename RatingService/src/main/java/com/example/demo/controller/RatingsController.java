package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Rating;
import com.example.demo.service.IRatingService;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

	private final IRatingService ratingService;
	
	
	public RatingsController(IRatingService ratingService) {
		super();
		this.ratingService = ratingService;
	}


	@PostMapping
	public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.addRating(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		return ResponseEntity.ok(ratingService.getAllRatings());
	}
	
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable("userId") Integer userId){
		
		return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable("hotelId") Integer hotelId){
		
		return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
	}
}
