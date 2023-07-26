package com.mss.springboot.web.app.CRUD.global.dto.utils;

public class Operations {
	
	
	public static String trimBrackeets(String message) {
		return message.replaceAll("[\\[\\]]", "");
	}
	
	
}