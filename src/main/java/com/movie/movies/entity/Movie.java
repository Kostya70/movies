package com.movie.movies.entity;


import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "filmmaker")
    private String filmmaker;

    @Column(name = "budget")
    private int budget;

    @Column(name = "estimation")
    private int estimation;

    public Movie() {
    }

    public Movie(int id, String title, String filmmaker, int budget, int estimation) {
        this.id = id;
        this.title = title;
        this.filmmaker = filmmaker;
        this.budget = budget;
        this.estimation = estimation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilmmaker() {
        return filmmaker;
    }

    public void setFilmmaker(String filmmaker) {
        this.filmmaker = filmmaker;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }
}
