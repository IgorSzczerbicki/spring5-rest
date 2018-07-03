package com.nauka.spring5.rest.crm.advise;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nauka.spring5.rest.crm.exceptions.CustomerErrorResponse;
import com.nauka.spring5.rest.crm.exceptions.CustomerException;

@ControllerAdvice
public class CustomerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handle(CustomerException exc){
		CustomerErrorResponse customerErrorResponse 
		= new CustomerErrorResponse(exc.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);
	}
}