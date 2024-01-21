package com.veroprojects.TryingThings.exception;

public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException(String message) {
        super(message);
    }
}
