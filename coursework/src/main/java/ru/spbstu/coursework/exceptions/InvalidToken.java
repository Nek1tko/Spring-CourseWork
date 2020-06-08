package ru.spbstu.coursework.exceptions;

import org.springframework.security.core.AuthenticationException;

public class InvalidToken extends AuthenticationException {
    private String message;

    public InvalidToken(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
