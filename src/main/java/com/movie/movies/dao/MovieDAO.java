package com.movie.movies.dao;

import com.movie.movies.entity.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getAllMovies();

    Movie saveMovie(Movie movie);

    Movie getMovie(int id);

    void deleteMovie(int id);
}
