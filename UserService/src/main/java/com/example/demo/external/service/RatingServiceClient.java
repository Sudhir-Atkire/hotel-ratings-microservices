package com.example.demo.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Rating;

@FeignClient(name="RATINGSERVICE")
public interface RatingServiceClient {

	@GetMapping("/ratings/users/{userId}")
	List<Rating> getRetings(@PathVariable("userId") Integer userId);
}
