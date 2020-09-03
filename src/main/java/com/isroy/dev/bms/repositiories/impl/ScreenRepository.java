package com.isroy.dev.bms.repositiories.impl;

import com.isroy.dev.bms.entities.Movie;
import com.isroy.dev.bms.entities.Screen;
import com.isroy.dev.bms.repositiories.IScreenRepository;

import java.util.HashMap;

public class ScreenRepository implements IScreenRepository {

    private HashMap<Long, Screen> screenDb;

    public ScreenRepository() {
        this.screenDb = new HashMap<>();
    }

    @Override
    public Screen findScreenById(Long screenId) {
        if(screenDb.containsKey(screenId))
            return screenDb.get(screenId);
        else
            return null;
    }

    @Override
    public void upsertScreen(Screen screen) {
        screenDb.put(screen.getScreenId(), screen);
    }
}
