package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

	private Integer ratingId;
	
	private Integer userId;
	
	private Integer hotelId;
	
	private int rating;
	
	private String feedback;
}
