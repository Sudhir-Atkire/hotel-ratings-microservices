package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GLobalExceptionHandler {

	@ExceptionHandler(HotelNotFoundException.class)
	public ProblemDetail handelHOtelNotFoundException(HotelNotFoundException ex) {
		
		ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		
		pd.setDetail(ex.getMessage());
		pd.setStatus(HttpStatus.NOT_FOUND);
		pd.setTitle("HOTEL NOT FOUND");
		return pd;
	}
}
