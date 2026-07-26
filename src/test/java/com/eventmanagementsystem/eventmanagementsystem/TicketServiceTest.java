package com.eventmanagementsystem.eventmanagementsystem;

import com.eventmanagementsystem.eventmanagementsystem.entity.Ticket;
import com.eventmanagementsystem.eventmanagementsystem.exception.ResourceNotFoundException;
import com.eventmanagementsystem.eventmanagementsystem.repository.TicketRepository;
import com.eventmanagementsystem.eventmanagementsystem.service.TicketServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TicketServiceTest {

    @Mock
    private TicketRepository repository;

    @InjectMocks
    private TicketServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBookTicket() {

        Ticket ticket = new Ticket();

        ticket.setTicketID(1);
        ticket.setUserID(1);
        ticket.setEventID(1);
        ticket.setStatus("Confirmed");

        when(repository.save(any(Ticket.class)))
                .thenReturn(ticket);

        Ticket result =
                service.bookTicket(ticket);

        assertEquals(
                "Confirmed",
                result.getStatus());
    }

    @Test
    void testGetTicketById() {

        Ticket ticket = new Ticket();

        ticket.setTicketID(1);
        ticket.setStatus("Confirmed");

        when(repository.findById(1))
                .thenReturn(Optional.of(ticket));

        Ticket result =
                service.getTicketById(1);

        assertEquals(
                "Confirmed",
                result.getStatus());
    }

    @Test
    void testTicketNotFound() {

        when(repository.findById(100))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> service.getTicketById(100));
    }

    @Test
    void testCancelTicket() {

        Ticket ticket = new Ticket();

        ticket.setTicketID(1);
        ticket.setStatus("Confirmed");

        when(repository.findById(1))
                .thenReturn(Optional.of(ticket));

        when(repository.save(any(Ticket.class)))
                .thenReturn(ticket);

        Ticket result =
                service.cancelTicket(1);

        assertNotNull(result);
        assertEquals(
                "Canceled",
                result.getStatus());
    }

    @Test
    void testDeleteTicket() {

        doNothing().when(repository)
                .deleteById(1);

        service.deleteTicket(1);

        verify(repository,
                times(1))
                .deleteById(1);
    }
}