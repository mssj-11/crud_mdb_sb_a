package com.mss.springboot.web.app.CRUD.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mss.springboot.web.app.CRUD.global.dto.MessageDto;



@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(ResourcesNotFoundEx.class)
	public ResponseEntity<MessageDto> throwNotFoundException(ResourcesNotFoundEx e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new MessageDto(HttpStatus.NOT_FOUND, e.getMessage()));
		
	}
	
	
	
}