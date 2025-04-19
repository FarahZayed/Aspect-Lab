package com.example.Lab4.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.LOCKED)
public class LockacquisitionException extends RuntimeException {
    public LockacquisitionException(String message) {
        super(message);
    }

    public LockacquisitionException(String message, Throwable cause) {
        super(message, cause);
    }
}