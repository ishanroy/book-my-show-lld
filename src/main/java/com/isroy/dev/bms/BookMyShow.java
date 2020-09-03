package com.isroy.dev.bms;

import com.isroy.dev.bms.entities.Movie;
import com.isroy.dev.bms.entities.Screen;
import com.isroy.dev.bms.entities.Show;
import com.isroy.dev.bms.entities.Ticket;
import com.isroy.dev.bms.exceptions.InvalidOperationException;
import com.isroy.dev.bms.exceptions.SeatNotLockedException;
import com.isroy.dev.bms.repositiories.impl.MovieRepository;
import com.isroy.dev.bms.repositiories.impl.ScreenRepository;
import com.isroy.dev.bms.repositiories.impl.ShowRepository;
import com.isroy.dev.bms.repositiories.impl.TicketRepository;
import com.isroy.dev.bms.services.admin.UpsertService;
import com.isroy.dev.bms.services.reservation.BookingService;
import com.isroy.dev.bms.services.reservation.PaymentService;
import com.isroy.dev.bms.services.search.RenderingService;
import com.isroy.dev.bms.wrapper.Booking;
import com.isroy.dev.bms.wrapper.Event;
import com.isroy.dev.bms.wrapper.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookMyShow {
    private BookingService bookingService;
    private RenderingService renderingService;
    private UpsertService upsertService;

    public BookMyShow(){
        ShowRepository showRepository = new ShowRepository();
        MovieRepository movieRepository = new MovieRepository();
        TicketRepository ticketRepository = new TicketRepository();
        ScreenRepository screenRepository = new ScreenRepository();

        bookingService = new BookingService(new PaymentService(),showRepository, ticketRepository);
        renderingService = new RenderingService(showRepository,ticketRepository,screenRepository);
        upsertService = new UpsertService(showRepository, movieRepository, screenRepository );
    }

    public List<Event> fetchEvents(Filter filter){
        List<Show> showList = renderingService.getShowsList(new com.isroy.dev.bms.services.search.Filter(filter.getTitle(), filter.getGenre(), filter.getLanguage(), filter.getPrice()));
        List<Event> events = showList.stream()
                .map(show -> new Event(show.getShowId(), show.getScreen().getScreenId(), show.getMovie().getTitle(), show.getMovie().getGenre(), show.getMovie().getLanguage()))
                .collect(Collectors.toList());
        return events;

    }

    public Boolean addOrUpdateEvents(List<Event> events){

        List<Show> shows = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();

        for(Event event : events){

            Movie movie = new Movie(event.getTitle(), event.getGenre(), event.getLanguage());
            movies.add(movie);

            Screen screen = renderingService.getScreen(event.getScreenId());
            Show show = new Show(event.getEventId(), screen, movie);

            shows.add(show);

        }
        upsertService.upsertMovies(movies);
        upsertService.upsertShows(shows);
        return true;
    }

    public Boolean[][] fetchEventSeatLayout(long eventId){
        return renderingService.fetchShowLayout(eventId);
    }

    public Boolean addLayout(Boolean[][] layout, long screenId){
        upsertService.upsertScreen(screenId, layout);
        return true;
    }

    public Long bookEvent(List<Long> seatIds, Long eventId, Long threatreId, Long user_id){
        Long bookingId = 0L;
        try {
            bookingId = bookingService.bookSeats(eventId, seatIds, user_id );
        } catch (SeatNotLockedException e) {
            e.printStackTrace();
        } catch (InvalidOperationException e) {
            e.printStackTrace();
        }
        return bookingId;
    }

    public Boolean lockSeats(List<Long> seatIds, Long eventId, Long threatreId,Long user_id) {
        Boolean result = null;
        try {
            result =  bookingService.lockSeats(eventId, seatIds, user_id);
        } catch (Exception ex){
           ex.printStackTrace();
        }
        return result;
    }

    public Booking fetchBooking(Long bookingId){
        Ticket ticket = renderingService.getBooking(bookingId);
        if(ticket != null)
            return new Booking(ticket.getBookingId(), ticket.getUserId(), ticket.getShowId(), ticket.getMovieId(), ticket.getSeatIds());
        else
            return  null;
     }
}
