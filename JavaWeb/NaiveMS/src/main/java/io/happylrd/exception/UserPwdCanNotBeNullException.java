package io.happylrd.exception;

public class UserPwdCanNotBeNullException extends Exception {
    public UserPwdCanNotBeNullException(String s) {
        super(s);
    }

    public UserPwdCanNotBeNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
