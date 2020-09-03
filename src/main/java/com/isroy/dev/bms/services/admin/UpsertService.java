package com.isroy.dev.bms.services.admin;

import com.isroy.dev.bms.entities.Movie;
import com.isroy.dev.bms.entities.Screen;
import com.isroy.dev.bms.entities.Show;
import com.isroy.dev.bms.repositiories.IMovieRepository;
import com.isroy.dev.bms.repositiories.IScreenRepository;
import com.isroy.dev.bms.repositiories.IShowrepository;
import com.isroy.dev.bms.repositiories.ITicketRepository;

import java.util.List;

public class UpsertService {

    IShowrepository showrepository;
    IMovieRepository movieRepository;
    IScreenRepository screenRepository;


    public UpsertService(IShowrepository showrepository, IMovieRepository movieRepository, IScreenRepository screenRepository) {
        this.showrepository = showrepository;
        this.movieRepository = movieRepository;
        this.screenRepository = screenRepository;

    }

    public void upsertShows(List<Show> shows){
        shows.stream().forEach(show -> showrepository.insertShow(show));
    }

    public void upsertMovies(List<Movie> movies){
        movies.stream().forEach(movie -> movieRepository.insertMovie(movie));
    }

    public void upsertScreen(long screenId, Boolean[][] layout){
            Screen screen = new Screen(screenId,layout);
            screenRepository.upsertScreen(screen);
    }



}
