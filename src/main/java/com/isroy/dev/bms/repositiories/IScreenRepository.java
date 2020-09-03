package com.isroy.dev.bms.repositiories;

import com.isroy.dev.bms.entities.Screen;
import com.isroy.dev.bms.entities.Show;

import java.util.List;

public interface IScreenRepository {
    public Screen findScreenById(Long screenId);
    public void upsertScreen (Screen screen);
}
