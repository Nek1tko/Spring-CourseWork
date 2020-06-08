package ru.spbstu.coursework.exceptions;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.ZonedDateTime;

@ControllerAdvice(basePackages = {"ru.spbstu.coursework.web"})
public class ExceptionsHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<Object> handleInvalidIdException(InvalidIdException e) {
        ResponseMessage responseMessage = new ResponseMessage(e.getMessage(),
                HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidUserOrPasswordException.class)
    public ResponseEntity<Object> handleInvalidUserOrPasswordException(InvalidUserOrPasswordException e) {
        ResponseMessage responseMessage = new ResponseMessage(e.getMessage(),
                HttpStatus.UNAUTHORIZED, ZonedDateTime.now());
        return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> handleSQLException(DataAccessException e, HttpServletRequest httpServletRequest) {
        ResponseMessage responseMessage;
        if (httpServletRequest.getMethod().equals("DELETE")) {
            responseMessage = new ResponseMessage("Could not delete. Entity is bound with work.",
                    HttpStatus.FORBIDDEN, ZonedDateTime.now());
        }
        else {
            responseMessage = new ResponseMessage(e.getMessage(),
                    HttpStatus.FORBIDDEN, ZonedDateTime.now());
        }
        return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleSQLException(SQLException e) {
        ResponseMessage responseMessage = new ResponseMessage(e.getMessage(),
                HttpStatus.FORBIDDEN, ZonedDateTime.now());
        return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
