package com.isroy.dev.bms.repositiories.impl;

import com.isroy.dev.bms.entities.Show;
import com.isroy.dev.bms.entities.Threatre;
import com.isroy.dev.bms.repositiories.ITheatreRepository;

import java.util.HashMap;

public class TheatreRepository implements ITheatreRepository {

    private HashMap<Long,Threatre> threatreHashMap;

    public TheatreRepository(){
        threatreHashMap = new HashMap<>();
    }

    @Override
    public Threatre findTheatreById(long theatreId) {
        if(threatreHashMap.containsKey(theatreId))
            return threatreHashMap.get(theatreId);
        else
            return null;
    }

    @Override
    public void addTheatre(Threatre threatre) {
        threatreHashMap.put(threatre.getThreatreId(),threatre);
    }
}
