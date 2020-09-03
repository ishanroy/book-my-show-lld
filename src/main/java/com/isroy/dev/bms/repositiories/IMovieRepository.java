package com.isroy.dev.bms.repositiories;

import com.isroy.dev.bms.entities.Movie;

import java.util.List;

public interface IMovieRepository {

    public Movie findMovieById(long movieId);
    public void insertMovie(Movie movie);
    public List<Movie> findAll();

}
