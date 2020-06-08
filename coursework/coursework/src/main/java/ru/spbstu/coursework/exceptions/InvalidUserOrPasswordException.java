package ru.spbstu.coursework.exceptions;


public class InvalidUserOrPasswordException extends RuntimeException {
    public InvalidUserOrPasswordException(String message) {
        super(message);
    }
}
