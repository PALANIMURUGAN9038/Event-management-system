package com.eventmanagementsystem.eventmanagementsystem.controller;

import com.eventmanagementsystem.eventmanagementsystem.entity.Ticket;
import com.eventmanagementsystem.eventmanagementsystem.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin("*")
public class TicketController {

    @Autowired
    private TicketService service;

    @PostMapping
    public Ticket bookTicket(@RequestBody Ticket ticket) {
        return service.bookTicket(ticket);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return service.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Integer id) {
        return service.getTicketById(id);
    }

    @GetMapping("/user/{userID}")
    public List<Ticket> getTicketsByUser(@PathVariable Integer userID) {
        return service.getTicketsByUser(userID);
    }

    @GetMapping("/event/{eventID}")
    public List<Ticket> getTicketsByEvent(@PathVariable Integer eventID) {
        return service.getTicketsByEvent(eventID);
    }

    @PutMapping("/cancel/{id}")
    public Ticket cancelTicket(@PathVariable Integer id) {
        return service.cancelTicket(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Integer id) {
        service.deleteTicket(id);
        return "Ticket deleted successfully";
    }
}