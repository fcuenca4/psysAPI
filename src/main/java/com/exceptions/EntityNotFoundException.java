package com.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends CustomException {

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String msg, Object[] args) {
        super(msg,args);
    }

}