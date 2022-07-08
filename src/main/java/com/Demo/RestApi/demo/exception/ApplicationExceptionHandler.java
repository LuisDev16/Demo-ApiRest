package com.Demo.RestApi.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ProductNotFoundException.class)
	public Map<String,String> handleBusinessException(ProductNotFoundException ex){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage",ex.getMessage());
		return errorMap;
	}
	


}
