package io.happylrd.exception;

public class UserCanNotBeNullException extends Exception {
    public UserCanNotBeNullException(String message) {
        super(message);
    }

    public UserCanNotBeNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
