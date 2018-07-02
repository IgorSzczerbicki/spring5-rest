package com.nauka.spring5.rest.api.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nauka.spring5.rest.api.exceptions.StudentErrorResponse;
import com.nauka.spring5.rest.api.exceptions.StudentNotFoundException;

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handle(StudentNotFoundException exc){
		
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		
		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(exc.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	// przechwytywanie pozostalych wyjatkow
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handle (Exception exc){
		
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		
		studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		studentErrorResponse.setMessage(exc.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
	}
}