package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException() {
        super("Entity not found!");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
