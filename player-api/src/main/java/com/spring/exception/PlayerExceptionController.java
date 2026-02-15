package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlayerExceptionController {

	@ExceptionHandler
	public ResponseEntity<PlayerExceptionResponse> handlePlayerException(PlayerException ex) {
		return new ResponseEntity<PlayerExceptionResponse>(
				new PlayerExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis()),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<PlayerExceptionResponse> handleException(Exception ex) {
		return new ResponseEntity<PlayerExceptionResponse>(new PlayerExceptionResponse(ex.getMessage(),
				HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
	}

}
