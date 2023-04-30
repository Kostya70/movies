package com.movie.movies.service;

import com.movie.movies.dao.MovieDAO;
import com.movie.movies.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieDAO movieDAO;

    @Override
    @Transactional
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    @Override
    @Transactional
    public void saveMovie(Movie movie) {
        movieDAO.saveMovie(movie);
    }

    @Override
    @Transactional
    public Movie getMovie(int id) {
        return movieDAO.getMovie(id);
    }

    @Override
    @Transactional
    public void deleteMovie(int id) {
        movieDAO.deleteMovie(id);
    }
}
