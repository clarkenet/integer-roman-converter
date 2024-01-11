package org.example.exception;

/**
 * Custom Application exception to handle number validation errors.
 */
public class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
    }
}
