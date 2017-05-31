package com.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String message;
    private Object[] args;

    public CustomException(String message, Object[] args) {
        super();
        this.message = message;
        this.args = args;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String code) {
        this.message = code;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

}