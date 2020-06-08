package com.ctl.LibraryManagement.Library.exception;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
@RestController
public class ExceptionHandlerclass  extends ResponseEntityExceptionHandler{
	
//	@ExceptionHandler(BookNotFoundException.class)
//	  public final ResponseEntity<ExceptionResponse> handleBookNotFoundException(BookNotFoundException ex) {
//		  ExceptionResponse errorDetails = new ExceptionResponse(new Date(), ex.getMessage(),
//	        ex.getMessage());
//	    return new ResponseEntity<ExceptionResponse>(errorDetails, HttpStatus.NOT_FOUND);
//	  }
	
	@Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach((error) -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            errors.put(fieldName, errorMessage);
	        });

	        ExceptionResponse errorMessageResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST.name(),
	                errors, "1001");

	        return new ResponseEntity<>(errorMessageResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
