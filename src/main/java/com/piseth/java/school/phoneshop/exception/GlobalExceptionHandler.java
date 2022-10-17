package com.piseth.java.school.phoneshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<?> handleHttpClientError(HttpClientErrorException e){
		ServiceException exception = new ServiceException(e.getStatusCode(), e.getMessage());
		return ResponseEntity.status(e.getStatusCode()).body(exception);
	}

}
