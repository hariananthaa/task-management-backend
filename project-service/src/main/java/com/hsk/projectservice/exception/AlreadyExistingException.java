package com.hsk.projectservice.exception;


public class AlreadyExistingException extends RuntimeException {

    public AlreadyExistingException() {
        super("User already exist.");
    }

    public AlreadyExistingException(String message) {
        super(message);
    }
}
