package com.movie.movies.service;

import com.movie.movies.entity.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> getAllMovies();

    public void saveMovie(Movie movie);

    public Movie getMovie(int id);

    public void deleteMovie(int id);
}
