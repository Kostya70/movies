package com.movie.movies.controller;

import com.movie.movies.entity.Movie;
import com.movie.movies.exception_handling.NoSuchMovieException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.movie.movies.service.MovieService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MovieRestController {

    @Autowired
    private MovieService movieService;
    @GetMapping("/movies")
    public List<Movie> showAllMovies(){
        List<Movie> allMovies = movieService.getAllMovies();
        return allMovies;
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable int id) {
        Movie movie = movieService.getMovie(id);

        if (movie ==null){
            throw new NoSuchMovieException("Ирина! Ну Ёб твою мать ID = " + id + " нет в базе");
        }

        return movie;
    }

    @PostMapping("/movies")
    public Movie addNewMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
        return movie;
    }

    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);

        return movie;
    }

    @DeleteMapping("/movies/{id}")
    public String deleteMovie(@PathVariable int id) {
        Movie movie = movieService.getMovie(id);
        if (movie==null){
            throw new NoSuchMovieException("Ирина! Ну Ёб твою мать ID = " + id + " нет в базе");
        }
        movieService.deleteMovie(id);

        return "Movie with ID=" + id + " was deleted";
    }

}
