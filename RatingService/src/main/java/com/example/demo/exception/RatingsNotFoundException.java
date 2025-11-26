package com.example.demo.exception;

public class RatingsNotFoundException extends RuntimeException{

	public RatingsNotFoundException() {
		super("Ratings not found...");
	}
	
	public RatingsNotFoundException(String msg) {
		super(msg);
	}
}
