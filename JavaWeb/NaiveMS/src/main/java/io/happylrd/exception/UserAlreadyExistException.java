package io.happylrd.exception;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String s) {
        super(s);
    }

    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
