package com.isroy.dev.bms.repositiories;

import com.isroy.dev.bms.entities.Show;
import com.isroy.dev.bms.entities.Threatre;

public interface ITheatreRepository {
    public Threatre findTheatreById(long theatreId);
    public void addTheatre (Threatre threatre);
}
