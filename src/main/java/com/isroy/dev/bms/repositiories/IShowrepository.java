package com.isroy.dev.bms.repositiories;

import com.isroy.dev.bms.entities.Show;

import java.util.List;

public interface IShowrepository {
    public Show findShowById(long showId);
    public void insertShow (Show show);
    public List<Show> findAll();
}
