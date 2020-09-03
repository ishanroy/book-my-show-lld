package com.isroy.dev.bms.wrapper;

import java.util.Map;

public class Event {
    private long eventId;
    private long screenId;
    private String title;
    private String language;
    private String genre;

    public Event(long eventId, long screenId, String title, String language, String genre) {
        this.eventId = eventId;
        this.screenId = screenId;
        this.title = title;
        this.language = language;
        this.genre = genre;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getScreenId() {
        return screenId;
    }

    public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
