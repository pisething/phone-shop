package com.piseth.java.school.phoneshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleHttpClientError(ApiException e){
		ErrorResponse errorResponse = new ErrorResponse(e.getStatus().getReasonPhrase(), e.getMessage());
		return ResponseEntity.status(e.getStatus())
				.body(errorResponse);
	}

}
