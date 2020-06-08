package ru.spbstu.coursework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler{
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidIdException.class)
    public void handleInvalidId() {
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidUserOrPassword.class)
    public void handleInvalidUserOrPassword() {
    }
}
