package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.exception.HotelNotFoundException;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.IHotelService;

@Service
public class HotelServiceImpl implements IHotelService {

	private final HotelRepository hotelRepository;
	
	
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotel(int hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(()-> new HotelNotFoundException("Hotel Not found for given ID  : "+hotelId));
		 
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
		
	}

	@Override
	public Hotel updateHotelDetails(Hotel hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHotel(int hotelId) {
		// TODO Auto-generated method stub

	}

}
