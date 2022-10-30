package com.piseth.java.school.phoneshop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	private String status;
	private String message;
}
