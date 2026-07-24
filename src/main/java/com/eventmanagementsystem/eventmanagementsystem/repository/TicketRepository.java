package com.eventmanagementsystem.eventmanagementsystem.repository;

import com.eventmanagementsystem.eventmanagementsystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByUserID(Integer userID);

    List<Ticket> findByEventID(Integer eventID);

    List<Ticket> findByStatus(String status);
}