package com.insure.myteam.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<ErrorDetails> clientNotFoundException(ClientNotFoundException exception,WebRequest request) {
		
		ErrorDetails message = new ErrorDetails(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message) ;
		
		
	}
	@ExceptionHandler(InsurencePolicyNotFoundException.class)
public ResponseEntity<ErrorDetails> insurencePolicyNotFoundException(InsurencePolicyNotFoundException exception,WebRequest request) {
		
		ErrorDetails message = new ErrorDetails(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message) ;
		
		
	}
	@ExceptionHandler(ClaimNotFoundException.class)

	
public ResponseEntity<ErrorDetails> ClaimNotFoundException(ClaimNotFoundException exception,WebRequest request) {
		
		ErrorDetails message = new ErrorDetails(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message) ;
		
		
	}
	

		

}
