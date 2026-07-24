package com.eventmanagementsystem.eventmanagementsystem.service;

import com.eventmanagementsystem.eventmanagementsystem.entity.Ticket;

import java.util.List;

public interface TicketService {

    Ticket bookTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket getTicketById(Integer id);

    List<Ticket> getTicketsByUser(Integer userID);

    List<Ticket> getTicketsByEvent(Integer eventID);

    Ticket cancelTicket(Integer id);

    void deleteTicket(Integer id);
}