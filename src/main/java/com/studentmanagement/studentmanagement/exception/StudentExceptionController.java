package com.studentmanagement.studentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.studentmanagement.studentmanagement.response.GlobalResponse;

@ControllerAdvice
public class StudentExceptionController {
	
	@ExceptionHandler(value=StudentNotFoundException.class)
	public ResponseEntity<Object> exception(StudentNotFoundException e){
		return new ResponseEntity<Object>(new GlobalResponse(false,"Student not found"),HttpStatus.NOT_FOUND);
	}

}
