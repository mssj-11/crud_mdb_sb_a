package com.mss.springboot.web.app.CRUD.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourcesNotFoundEx extends Exception{
	
	public ResourcesNotFoundEx(String message) {
		super(message);
	}
	
	
}