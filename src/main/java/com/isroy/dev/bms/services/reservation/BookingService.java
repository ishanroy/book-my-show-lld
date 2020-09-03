package com.isroy.dev.bms.services.reservation;

import com.isroy.dev.bms.entities.Ticket;
import com.isroy.dev.bms.entities.Seat;
import com.isroy.dev.bms.entities.Show;
import com.isroy.dev.bms.exceptions.InvalidOperationException;
import com.isroy.dev.bms.exceptions.SeatNotLockedException;
import com.isroy.dev.bms.repositiories.IShowrepository;
import com.isroy.dev.bms.repositiories.ITicketRepository;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BookingService {

    PaymentService paymentService;
    IShowrepository showrepository;
    ITicketRepository ticketRepository;

    public BookingService(PaymentService paymentService, IShowrepository showrepository, ITicketRepository ticketRepository) {
        this.paymentService = paymentService;
        this.showrepository = showrepository;
        this.ticketRepository = ticketRepository;
    }

    public Boolean lockSeats(long showId, List<Long> seatIds, long userId) throws InvalidOperationException {
        Show show = showrepository.findShowById(showId);
        if(show == null)
            throw new InvalidOperationException("ShowId is invalid.");
        HashMap<Long,Seat> seatMap = show.getScreen().getSeatMap();
        List<Long> lockedSeats = new ArrayList<>();
        Collections.sort(seatIds);
        boolean success = true;
        for(long seatId : seatIds){
            Seat seat = seatMap.get(seatId);
            if(seat != null){
                if(seat.lockSeat(userId))
                    lockedSeats.add(seatId);
                else{
                    success = false;
                    for(long lockedSeat : lockedSeats){
                        Seat s = seatMap.get(lockedSeat);
                        s.unLockSeat();
                    }
                    break;
                }
            }
        }
        if(success)
            return true;
        else
            return false;
    }

    public Long bookSeats (long showId, List<Long> seatIds, long userId ) throws SeatNotLockedException, InvalidOperationException {
        Show show = showrepository.findShowById(showId);
        if(show == null)
            throw new InvalidOperationException("ShowId is invalid.");
        HashMap<Long,Seat> seatMap = show.getScreen().getSeatMap();
        double amount  = show.getPricePerTicket() * seatIds.size();
        boolean paymentStatus = false;

        if(validateSeatLocks(seatIds,userId,seatMap)) {
            paymentStatus = paymentService.makePayment(amount, userId);
        }

        if(paymentStatus) {
           for(long seatId : seatIds){
               seatMap.get(seatId).bookSeat(userId);
           }

           Ticket ticket =new Ticket(userId, showId, show.getMovie().getMovieId(),seatIds);
           ticketRepository.addTicket(ticket);

            return ticket.getBookingId();
        }else{
            System.out.println("Payment failed for user: " + userId);
            for(long seatId : seatIds){
                seatMap.get(seatId).unLockSeat();
            }
        }
        return null;
    }

    public Boolean validateSeatLocks(List<Long> seatIds, long userId, HashMap<Long,Seat> seatMap) throws InvalidOperationException {
        for(long seatId : seatIds){
            Seat seat = seatMap.get(seatId);
            if(seat != null){
                if(seat.getUserId() != userId)
                    return false;
            }
            else
                throw new InvalidOperationException("Seat not present at the location");

        }
        return true;
    }

}
