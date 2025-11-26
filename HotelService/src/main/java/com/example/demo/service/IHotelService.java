package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hotel;

public interface IHotelService {
	
	Hotel addHotel(Hotel hotel);
	
	Hotel getHotel(int hotelId);
	
	List<Hotel> getAllHotels();
	
	Hotel updateHotelDetails(Hotel hotel);
	
	void deleteHotel(int hotelId);

}
