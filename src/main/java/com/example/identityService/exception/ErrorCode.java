package com.example.identityService.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION( "Uncategorized error", 1000, HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXISTED( "User existed", 1001  , HttpStatus.BAD_REQUEST),
    USERNAME_INVALID("Username must be at least 3 characters", 1002, HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID("Password must be at least 8 characters", 1003, HttpStatus.BAD_REQUEST),
    KEY_INVALID("Invalid message key", 1004, HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED( "User not existed", 1005, HttpStatus.NOT_FOUND),
    UNAUTHENTICATED("Unauthenticated", 1006, HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED("You do not have permission", 1007, HttpStatus.FORBIDDEN),
    INVALID_TOKEN("Invalid token", 1008, HttpStatus.UNAUTHORIZED)
    ;

    private int code;
    private String message;
    private HttpStatusCode statusCode;
    ErrorCode(String message, int code, HttpStatusCode statusCode) {
        this.message = message;
        this.code = code;
        this.statusCode = statusCode;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
