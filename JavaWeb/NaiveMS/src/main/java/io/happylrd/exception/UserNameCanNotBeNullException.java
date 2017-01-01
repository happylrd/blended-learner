package io.happylrd.exception;

public class UserNameCanNotBeNullException extends Exception {
    public UserNameCanNotBeNullException(String s) {
        super(s);
    }

    public UserNameCanNotBeNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
