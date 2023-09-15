package com.hsk.taskservice.exception;

public class VerificationFailedException extends RuntimeException {
    public VerificationFailedException() {
        super("Verification failed. Try again.");
    }

    public VerificationFailedException(String message) {
        super(message);
    }
}
