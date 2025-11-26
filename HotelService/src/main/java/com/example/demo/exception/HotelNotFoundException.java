package com.example.demo.exception;


public class HotelNotFoundException extends RuntimeException{

	HotelNotFoundException(){
	  super("Hotel Not Found!!!");	
	}
	
	HotelNotFoundException(String msg){
		 super(msg);	
	}
}
