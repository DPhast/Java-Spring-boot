package com.example.identityService.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION( "Uncategorized error", 9999),
    USER_EXISTED( "User existed", 1001  ),
    USERNAME_INVALID("Username must be at least 3 characters", 1002),
    PASSWORD_INVALID("Password must be at least 8 characters", 1003),
    KEY_INVALID("Invalid message key", 1004),
    USER_NOT_EXISTED( "User not existed", 1005  )
    ;

    private int code;
    private String message;

    ErrorCode(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
