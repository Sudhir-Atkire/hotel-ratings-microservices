package com.example.demo.exception;


public class HotelNotFoundException extends RuntimeException{

	public HotelNotFoundException(){
	  super("Hotel Not Found!!!");	
	}
	
	public HotelNotFoundException(String msg){
		 super(msg);	
	}
}
