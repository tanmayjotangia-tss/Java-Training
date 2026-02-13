package com.tss.day16.assignment.movies.exception;

public class NoSuchMovieFoundException extends RuntimeException {
    public NoSuchMovieFoundException(String message) {
        super(message);
    }
}
