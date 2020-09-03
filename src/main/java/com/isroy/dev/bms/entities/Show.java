package com.isroy.dev.bms.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Show {

    private long showId;
    private Date time;
    private Double pricePerTicket;
    private Screen screen;
    private Movie movie;

    public Show(long showId, Date time, Double pricePerTicket, Screen screen, Movie movie) {
        this.showId = showId;
        this.time = time;
        this.pricePerTicket = pricePerTicket;
        this.screen = screen;
        this.movie = movie;
    }

    public Show(long showId, Screen screen, Movie movie) {
        this.showId = showId;
        this.time = new Date();
        this.screen = screen;
        this.movie = movie;
        this.pricePerTicket = Math.random() * 100.0;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getPricePerTicket() {
        return pricePerTicket;
    }

    public void setPricePerTicket(Double pricePerTicket) {
        this.pricePerTicket = pricePerTicket;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
