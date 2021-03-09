package com.verinite.dummyInterestApp.exception;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class PlanException extends ResponseEntityExceptionHandler {
    private ResponseEntity<ApiError> getErrorResponse(PlanErrorCode errorCode, Exception e) {
		
        String errorMessage = errorCode.getErrorMessage();

        log.warn(errorCode.getErrorMessage(), e.getMessage(), e.getClass().getName(),errorCode.getErrorCode());
            
        if (e instanceof PlanCustomException) {
            errorMessage = e.getMessage();
        }
        ApiError errorResponse = ApiError.builder()
                .code(errorCode.getErrorCode())
                .message(errorMessage)
                .debugId("debugId")
                .build();
        return new ResponseEntity<>(errorResponse, errorCode.getErrorStatus());
    }
	
	@ExceptionHandler(value = { PlanCustomException.class })
	public ResponseEntity<ApiError> handleException(PlanCustomException e) {
		return getErrorResponse(e.getPlanErrorCode(), e);
	}

	@ExceptionHandler(value = { IllegalArgumentException.class })
	public ResponseEntity<ApiError> handleException(IllegalArgumentException e) {
		return getErrorResponse(PlanErrorCode.CONFLICT, e);
	}
	
	
	@ExceptionHandler(value = { IOException.class })
	public ResponseEntity<ApiError> handleException(IOException e) {
		return getErrorResponse(PlanErrorCode.CONFLICT, e);
	}
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ApiError> handleException(Exception e) {
		return getErrorResponse(PlanErrorCode.INTERNAL_SERVER_ERROR, e);
	}
}
