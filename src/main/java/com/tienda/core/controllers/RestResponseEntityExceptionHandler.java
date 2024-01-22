package com.tienda.core.controllers;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tienda.core.exceptions.BadRequestException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request){
		
		Map<String, Object> body = new LinkedHashMap<>(); 
		body.put("timestamp", LocalDateTime.now()); 
		body.put("message", ex.getMessage()); 
		body.put("Error", HttpStatus.BAD_REQUEST.toString()); 
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
}
