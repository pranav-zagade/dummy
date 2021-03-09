package com.verinite.dummyInterestApp.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlanErrorCode {

    INTERNAL_SERVER_ERROR("ER000", "Unexpected server error occurred", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST("ER001", "Bad request", HttpStatus.BAD_REQUEST),
    CONFLICT("ER002", "Conflicting input", HttpStatus.CONFLICT),
    NOT_FOUND("ER003", "Resource not found", HttpStatus.NOT_FOUND),
    UNAUTHORIZED("ER004", "Unauthorized action", HttpStatus.UNAUTHORIZED),
    PRODUCT_ALREADY_EXISTS("ER005", "Conflicting input", HttpStatus.CONFLICT),
    ENROLLMENT_FAILED_DUE_TO_PRECONDITION("ER006", "Precondition not fulfilled", HttpStatus.PRECONDITION_FAILED),
    PRODUCT_IDENTIFICATION_FAILED("ER007", "Not enough data to identify product", HttpStatus.CONFLICT);

    private String errorCode;
    private String errorMessage;
    private HttpStatus errorStatus;
    
}
