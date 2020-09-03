package com.isroy.dev.bms.repositiories.impl;

import com.isroy.dev.bms.entities.Ticket;
import com.isroy.dev.bms.repositiories.ITicketRepository;

import java.util.HashMap;

public class TicketRepository implements ITicketRepository {

    private HashMap<Long,Ticket> ticketHashMap;

    public TicketRepository(){
        ticketHashMap = new HashMap<>();
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticketHashMap.put(ticket.getBookingId(), ticket);
    }

    @Override
    public Ticket findTicketById(Long ticketId) {
        if(ticketHashMap.containsKey(ticketId)){
            return ticketHashMap.get(ticketId);
        }
        else{
            return null;
        }
    }
}
