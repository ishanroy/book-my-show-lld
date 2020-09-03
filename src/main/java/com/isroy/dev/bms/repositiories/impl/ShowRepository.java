package com.isroy.dev.bms.repositiories.impl;

import com.isroy.dev.bms.entities.Show;
import com.isroy.dev.bms.repositiories.IShowrepository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ShowRepository implements IShowrepository {

    private HashMap<Long,Show> showDb;

    public ShowRepository(){
        showDb = new HashMap<>();
    }

    @Override
    public Show findShowById(long showId) {
        if(showDb.containsKey(showId))
            return showDb.get(showId);
        else
            return null;
    }

    @Override
    public void insertShow(Show show) {
        showDb.put(show.getShowId(),show);
    }

    @Override
    public List<Show> findAll() {
        return showDb.values().stream().collect(Collectors.toList());
    }
}
