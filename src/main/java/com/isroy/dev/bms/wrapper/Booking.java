package com.isroy.dev.bms.wrapper;

import java.util.List;

public class Booking {
    private long id;
    private long userId;
    private long screenId;
    private long eventId;
    private List<Long> seatNumbers;

    public Booking() {
    }

    public Booking(long id, long userId, long screenId, long eventId, List<Long> seatNumbers) {
        this.id = id;
        this.userId = userId;
        this.screenId = screenId;
        this.eventId = eventId;
        this.seatNumbers = seatNumbers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getScreenId() {
        return screenId;
    }

    public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public List<Long> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<Long> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", userId=" + userId +
                ", screenId=" + screenId +
                ", eventId=" + eventId +
                ", seatNumbers=" + seatNumbers +
                '}';
    }
}
