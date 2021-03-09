package com.verinite.dummyInterestApp.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class PlanCustomException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final PlanErrorCode planErrorCode;

    public PlanCustomException(PlanErrorCode errorCode, String message) {
    	
        super(message);
        this.planErrorCode = errorCode;
    }

    public PlanCustomException(PlanErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.planErrorCode = errorCode;
    }

    public PlanCustomException(PlanErrorCode errorCode, Throwable cause) {
        super(cause);
        this.planErrorCode = errorCode;
    }
    
}
