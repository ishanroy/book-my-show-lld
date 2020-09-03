package com.isroy.dev.bms.services.search;

import com.isroy.dev.bms.entities.Screen;
import com.isroy.dev.bms.entities.Seat;
import com.isroy.dev.bms.entities.Show;
import com.isroy.dev.bms.entities.Ticket;
import com.isroy.dev.bms.repositiories.IScreenRepository;
import com.isroy.dev.bms.repositiories.IShowrepository;
import com.isroy.dev.bms.repositiories.ITicketRepository;


import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RenderingService {

    IShowrepository showrepository;
    ITicketRepository ticketRepository;
    IScreenRepository screenRepository;

    public RenderingService(IShowrepository showrepository, ITicketRepository ticketRepository, IScreenRepository screenRepository) {
        this.showrepository = showrepository;
        this.ticketRepository = ticketRepository;
        this.screenRepository = screenRepository;
    }

    public List<Show> getShowsList(Filter filter){
        List<Show> shows = showrepository.findAll().stream()
                                            .filter(s -> s.getMovie().getGenre().toLowerCase().matches(filter.getGenre()))
                                            .filter(s -> s.getMovie().getLanguage().toLowerCase().matches(filter.getLanguage()))
                                            .filter(s -> s.getMovie().getTitle().toLowerCase().matches(filter.getTitle()))
                                            .filter(show -> show.getPricePerTicket() >= filter.getPriceRangeLow() && show.getPricePerTicket() <= filter.getPriceRangeHigh())
                                            .collect(Collectors.toList());

        return shows;
    }

    public Boolean[][] fetchShowLayout(long showId){
        Show show = showrepository.findShowById(showId);
        Screen screen = show.getScreen();
        int row = screen.getRows();
        int col = screen.getCols();
        Boolean[][] seatView = new Boolean[row][col];
        HashMap<Long,Seat> seatsMap = screen.getSeatMap();

        for(int i = 0 ; i < screen.getRows() ; i++){
            for(int j = 0 ; j < screen.getCols(); j++ ){
                Seat seat = seatsMap.get(i*row + j + 1l);
                if(seat != null)
                    seatView[i][j] = !seat.isLocked();
                else
                    seatView[i][j] = null;
            }
        }
        return seatView;
    }

    public Ticket getBooking(Long bookingId){
        return ticketRepository.findTicketById(bookingId);
    }

    public Screen getScreen(Long screenId){
        return screenRepository.findScreenById(screenId);
    }

}
