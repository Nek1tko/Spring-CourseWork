package ru.spbstu.coursework.exceptions;


public class InvalidUserOrPassword extends RuntimeException {
    private String message;

    public InvalidUserOrPassword(String message) {
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
