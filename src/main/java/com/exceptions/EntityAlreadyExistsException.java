package com.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntityAlreadyExistsException extends CustomException {

    private static final long serialVersionUID = 1L;

    public EntityAlreadyExistsException(String msg, Object[] args) {
        super(msg,args);
    }

}
