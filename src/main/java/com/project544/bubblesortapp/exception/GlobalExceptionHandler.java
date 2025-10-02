package com.project544.bubblesortapp.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){
        String errorMessages = ex.getBindingResult().getAllErrors()
                .stream()
                .map(err -> Optional.ofNullable(err.getDefaultMessage()).orElse("Validation failed")).min((a, b) -> {
                    if (a.contains("null or empty")) return -1;
                    if (b.contains("null or empty")) return 1;
                    return 0;
                })
                .orElse("Validation failed");

        logger.warn("Validation failed at {}:{}", request.getRequestURI(), errorMessages);

        HttpStatus status=HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse=new ErrorResponse(errorMessages, status.value(), status.name());
        return new ResponseEntity<>(errorResponse,status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, HttpServletRequest request){
        logger.error("Unexpected error at {}:{}",request.getRequestURI(),ex.getMessage(),ex);
        HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse=new ErrorResponse("Unexpected error: "+ex.getMessage(),status.value(), status.name());
        return new ResponseEntity<>(errorResponse,status);
    }
}
