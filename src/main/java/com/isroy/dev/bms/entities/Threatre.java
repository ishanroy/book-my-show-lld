package com.isroy.dev.bms.entities;

import java.util.List;

public class Threatre {
    private Long threatreId;
    private List<Show> shows;

    public Threatre(Long threatreId, List<Show> shows) {
        this.threatreId = threatreId;
        this.shows = shows;
    }

    public Long getThreatreId() {
        return threatreId;
    }

    public void setThreatreId(Long threatreId) {
        this.threatreId = threatreId;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}

