package com.isroy.dev.bms.repositiories;


import com.isroy.dev.bms.entities.Ticket;

public interface ITicketRepository {
    public void addTicket(Ticket ticket);
    public Ticket findTicketById(Long ticketId);
}
