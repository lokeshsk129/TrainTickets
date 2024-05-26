package com.Ticket.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket purchaseTicket(String from, String to, User user, double price, String seatSection) {
        userRepository.save(user);
        Ticket ticket = new Ticket();
        ticket.setFromLocation(from);
        ticket.setToLocation(to);
        ticket.setUser(user);
        ticket.setPrice(price);
        ticket.setSeatSection(seatSection);
        return ticketRepository.save(ticket);
    }

    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public List<Ticket> getTicketsBySection(String section) {
        return ticketRepository.findBySeatSection(section);
    }

    public void removeUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public Ticket modifySeat(Long ticketId, String newSeatSection) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket != null) {
            ticket.setSeatSection(newSeatSection);
            return ticketRepository.save(ticket);
        }
        return null;
    }
}