package com.example.Lab4.Exceptions;




import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//throw in aspect

@ResponseStatus(value = HttpStatus.TOO_MANY_REQUESTS)
public class RateLimitExceededException extends RuntimeException {
    public RateLimitExceededException(String message) {
        super(message);
    }
}