package com.zaloni.application.common.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.zaloni.application.common.vo.APIErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(value={NoHandlerFoundException.class})
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public APIErrorResponse requestHandlingNoHandlerFound(final NoHandlerFoundException ex) {
		
		return new APIErrorResponse("custom_404", Arrays.asList(ex.getMessage()));
    }
	
	@ExceptionHandler(value={MethodArgumentNotValidException.class})
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ResponseBody
    public APIErrorResponse handleMethodArgumentNotValid(final MethodArgumentNotValidException ex) {
		final List<String> errors = new ArrayList<String>();
		
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        
		
		return new APIErrorResponse("custom_400", errors);
        
    }
	
	@ExceptionHandler(value={HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(value= HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public APIErrorResponse handleMethodNotFound(final HttpRequestMethodNotSupportedException ex) {
		
		return new APIErrorResponse("custom_405", Arrays.asList(ex.getMessage()));
    }
	
	@ExceptionHandler(value={HttpMediaTypeNotSupportedException.class})
    @ResponseStatus(value= HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public APIErrorResponse handleMediaUnsupported(final HttpMediaTypeNotSupportedException ex) {
		
		return new APIErrorResponse("custom_415", Arrays.asList(ex.getMessage()));
    }

}
