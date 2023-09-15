package com.hsk.projectservice.exception;

public class VerificationFailedException extends RuntimeException {
    public VerificationFailedException() {
        super("Verification failed. Try again.");
    }

    public VerificationFailedException(String message) {
        super(message);
    }
}
