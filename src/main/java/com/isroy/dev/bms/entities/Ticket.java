package com.isroy.dev.bms.entities;

import java.util.List;

public class Ticket {

    private long bookingId;
    private long userId;
    private long showId;
    private long movieId;
    private List<Long> seatIds;



    private static long ticketIdCounter = 10000L;

    public Ticket(long userId, long showId, long movieId, List<Long> seatIds) {
        this.bookingId = ticketIdCounter++;
        this.userId = userId;
        this.showId = showId;
        this.movieId = movieId;
        this.seatIds = seatIds;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public List<Long> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<Long> seatIds) {
        this.seatIds = seatIds;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getUserId() {
        return userId;
    }

    public long getShowId() {
        return showId;
    }

    public long getMovieId() {
        return movieId;
    }

}
