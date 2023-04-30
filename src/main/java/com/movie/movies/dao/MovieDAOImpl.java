package com.movie.movies.dao;

import com.movie.movies.entity.Movie;


import jakarta.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




import java.util.List;


@Repository
public class MovieDAOImpl implements MovieDAO{

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Movie> getAllMovies() {

        Query<Movie> query = (Query<Movie>) entityManager.createQuery("from Movie");
        List<Movie> allMovies = query.getResultList();
        return allMovies;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return entityManager.merge(movie);
    }

    @Override
    public Movie getMovie(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Movie> query = session.createQuery("delete from Movie " + "where id =:movie");
        Movie movie = session.get(Movie.class, id);
        return movie;
    }

    @Override
    public void deleteMovie(int id) {
        Query query = (Query) entityManager.createQuery("delete from Movie where id = :movieId");
        query.setParameter("movieId", id);
        query.executeUpdate();
    }
}
