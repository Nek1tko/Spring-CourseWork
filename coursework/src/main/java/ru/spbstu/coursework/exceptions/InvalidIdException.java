package ru.spbstu.coursework.exceptions;

public class InvalidIdException extends RuntimeException {
    Integer id;

    public InvalidIdException(Integer id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "There is no entity with such id = " + id;
    }

    @Override
    public String toString() {
        return "There is no entity with such id = " + id;
    }
}
