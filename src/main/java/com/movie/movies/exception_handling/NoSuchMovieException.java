package com.movie.movies.exception_handling;

public class NoSuchMovieException extends RuntimeException{
    public NoSuchMovieException(String message) {
        super(message);
    }
}
