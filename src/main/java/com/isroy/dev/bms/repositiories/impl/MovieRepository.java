package com.isroy.dev.bms.repositiories.impl;

import com.isroy.dev.bms.entities.Movie;
import com.isroy.dev.bms.repositiories.IMovieRepository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRepository implements IMovieRepository {

    private HashMap<Long, Movie> movieDb;

    public MovieRepository(){
            movieDb = new HashMap<>();
    }

    @Override
    public Movie findMovieById(long movieId) {
        if(movieDb.containsKey(movieId))
            return movieDb.get(movieId);
        else
            return null;
    }

    @Override
    public void insertMovie(Movie movie) {
        movieDb.put(movie.getMovieId(), movie);

    }

    @Override
    public List<Movie> findAll() {
        return movieDb.values().stream().collect(Collectors.toList());
    }
}
