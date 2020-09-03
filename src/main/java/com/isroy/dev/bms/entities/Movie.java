package com.isroy.dev.bms.entities;

import java.util.List;

public class Movie {
    private long movieId;
    private String title;
    private String genre;
    private String language;
    private String rating;

    private static long movieIdCounter = 2000l;

    public Movie() {
    }

    public Movie( String title, String genre, String language) {
        this.movieId = movieIdCounter++;
        this.title = title;
        this.genre = genre;
        this.language = language;

    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
