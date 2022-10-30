package com.piseth.java.school.phoneshop.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ApiException extends RuntimeException{ 
	
	private HttpStatus status;
	private String message;
}
