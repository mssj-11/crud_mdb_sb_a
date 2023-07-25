package com.mss.springboot.web.app.CRUD.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mss.springboot.web.app.CRUD.global.dto.MessageDto;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AttributeException extends Exception{
	
	public AttributeException(String message) {
		super(message);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MessageDto> throwAttributeException(AttributeException e){
		return ResponseEntity.badRequest().body(new MessageDto(HttpStatus.BAD_REQUEST, e.getMessage()));
	}
	
	
}