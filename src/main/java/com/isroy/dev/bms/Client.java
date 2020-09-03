package com.isroy.dev.bms;

import com.isroy.dev.bms.wrapper.Booking;
import com.isroy.dev.bms.wrapper.Event;
import com.isroy.dev.bms.wrapper.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Client Class with the APIs defined in the assignment.
 *
 */
public class Client
{

    public static void main( String[] args ) {
        BookMyShow bookMyShow = new BookMyShow();

        // Load screen and movies .
        Boolean screen1[][] = new Boolean[][]{
                { true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true },
                { false, false, true, true, true, true, true, true, false, false },
                { false, false, true, true, true, true, true, true, false, false }
        };
        Boolean screen2[][] = new Boolean[][]{
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true}
        };
        bookMyShow.addLayout(screen1, 1001l);
        bookMyShow.addLayout(screen2, 1002l);

        Event event1 = new Event(1001l, 1001l, "Spiderman", "English", "Action");
        Event event2 = new Event( 1002l, 1002l, "Superman", "Hindi", "Comedy");
        List<Event> events = new ArrayList<>();
        events.add(event1);
        events.add(event2);

        bookMyShow.addOrUpdateEvents(events);

        //Fetch movies
        System.out.println(bookMyShow.fetchEvents(new Filter("Spiderman","", "" , "")).toString());
        System.out.println(bookMyShow.fetchEvents(new Filter("","Comedy", "" , "" )).toString());


        //Fetch Layout
        System.out.println("Layout for first event");
        printLayout(bookMyShow.fetchEventSeatLayout(1001l));

        System.out.println("Layout for second event");
        printLayout(bookMyShow.fetchEventSeatLayout(1002l));

        //Lock and Book Seats
        System.out.println("Locking seats 4-8 in first event");
        List<Long> seats = new ArrayList<>();
        seats.add(4l); seats.add(5l); seats.add(6l); seats.add(7l); seats.add(8l);
        bookMyShow.lockSeats(seats,1001l,1l,1001l);
        System.out.println("Booking seats 4-8 in first event");
        Long booking1 = bookMyShow.bookEvent(seats, 1001l, 1l, 1001l);

        System.out.println("Locking seats 2-4 in second event");
        List<Long> seats1 = new ArrayList<>();
        seats1.add(2l); seats1.add(3l); seats1.add(4l);
        bookMyShow.lockSeats(seats1,1002l,1l,1002l);
        System.out.println("Booking seats 2-4 in second event");
        Long booking2 = bookMyShow.bookEvent(seats1, 1002l, 1l, 1002l);

        System.out.println("Layouts after booking :");
        System.out.println("Layout for first event");
        printLayout(bookMyShow.fetchEventSeatLayout(1001l));

        System.out.println("Layout for second event");
        printLayout(bookMyShow.fetchEventSeatLayout(1002l));


        //Print booking details
        Booking booking11 = bookMyShow.fetchBooking(booking1);
        System.out.println(booking11);

        Booking booking12 = bookMyShow.fetchBooking(booking2);
        System.out.println(booking12);


    }

    public static void printLayout(Boolean[][] layout){
        for(int i = 0; i < layout.length ; i++){
            for(int j = 0 ; j < layout[0].length; j++){
                System.out.print(layout[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

