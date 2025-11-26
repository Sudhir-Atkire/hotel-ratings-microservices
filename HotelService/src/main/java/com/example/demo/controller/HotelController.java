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

import com.example.demo.entity.Hotel;
import com.example.demo.service.IHotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	private final IHotelService hotelService;

	public HotelController(IHotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}
	
	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.addHotel(hotel));
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") int  hotelId){
		
		return ResponseEntity.ok(hotelService.getHotel(hotelId));
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
	
	
}
