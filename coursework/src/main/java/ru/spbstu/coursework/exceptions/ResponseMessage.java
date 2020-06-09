package ru.spbstu.coursework.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ResponseMessage {
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timeStamp;

    public ResponseMessage(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
