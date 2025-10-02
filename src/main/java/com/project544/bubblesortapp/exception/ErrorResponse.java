package com.project544.bubblesortapp.exception;

/**
 * generate common error response
 */
public class ErrorResponse {
    private String message;
    private int statusCode;
    private String httpStatus;

    public ErrorResponse(String message, int statusCode, String httpStatus) {
        this.message = message;
        this.statusCode = statusCode;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }
}
