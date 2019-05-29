package com.spring.rest.jackson.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice        //Global controller
public class SpringRestGlobalExceptionHandler {

	//Add exception Handeler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException	 exe)
	{
		//Create a 	StudentErrorResponse
		StudentErrorResponse error=new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exe.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	/*OUTPUT: {"status":404,"message":"Student is not found -99","timeStamp":155915*/
	
	// Add an exception handeler catch any exception (catch all)
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception	 exe)
	{
		//Create a 	StudentErrorResponse
		StudentErrorResponse error=new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exe.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	/*Output:-{"status":400,"message":"Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: \"asd\"","timeStamp":1559152708748}*/
}