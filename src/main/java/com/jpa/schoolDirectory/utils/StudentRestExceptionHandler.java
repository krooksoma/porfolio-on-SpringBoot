package com.jpa.schoolDirectory.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class StudentRestExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(new Date(System.currentTimeMillis()));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    //add another generic Exception Handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (Exception exc){

        StudentErrorResponse error = new StudentErrorResponse();

        //400 response instead of 404(NOT_FOUND)
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(new Date(System.currentTimeMillis()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
