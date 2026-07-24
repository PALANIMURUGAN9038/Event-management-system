package com.eventmanagementsystem.eventmanagementsystem.service;

import com.eventmanagementsystem.eventmanagementsystem.entity.Ticket;
import com.eventmanagementsystem.eventmanagementsystem.exception.ResourceNotFoundException;
import com.eventmanagementsystem.eventmanagementsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository repository;

    @Override
    public Ticket bookTicket(Ticket ticket) {

        ticket.setBookingDate(new Date());

        if (ticket.getStatus() == null || ticket.getStatus().isEmpty()) {
            ticket.setStatus("Confirmed");
        }

        return repository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return repository.findAll();
    }

    @Override
    public Ticket getTicketById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ticket Not Found"));
    }
    @Override
    public List<Ticket> getTicketsByUser(Integer userID) {
        return repository.findByUserID(userID);
    }

    @Override
    public List<Ticket> getTicketsByEvent(Integer eventID) {
        return repository.findByEventID(eventID);
    }

    @Override
    public Ticket cancelTicket(Integer id) {

        Ticket ticket = repository.findById(id).orElse(null);

        if (ticket != null) {
            ticket.setStatus("Canceled");
            return repository.save(ticket);
        }

        return null;
    }

    @Override
    public void deleteTicket(Integer id) {
        repository.deleteById(id);
    }
}