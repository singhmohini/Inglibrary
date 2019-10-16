package com.hcl.inglibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(InvalidUserException exception) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(InvalidCredentialsException exception) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}




	@ExceptionHandler(CommonException.class)
	public ResponseEntity<ResponseError> commonException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}


}