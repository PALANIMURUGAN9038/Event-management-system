package com.eventmanagementsystem.eventmanagementsystem.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID")
    private Integer ticketID;

    @Column(name = "EventID")
    private Integer eventID;

    @Column(name = "UserID")
    private Integer userID;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BookingDate")
    private Date bookingDate;

    @Column(name = "Status")
    private String status;

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}