package com.example.demo.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface HotelServiceClient {
	
	@GetMapping("/hotels/{hotelId}")
	 Hotel getHotel(@PathVariable("hotelId") Integer hotelId); 
}
