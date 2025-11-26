package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Rating;

@Repository
public interface RatingsRepository extends JpaRepository<Rating, Integer> {

	List<Rating> findByUserId(Integer userId);
	
	List<Rating> findByHotelId(Integer hotelId);
}
