package com.Ticket.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestParam String from,
                                 @RequestParam String to,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam String email,
                                 @RequestParam double price,
                                 @RequestParam String seatSection) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        return ticketService.purchaseTicket(from, to, user, price, seatSection);
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketService.getTicket(id);
    }

    @GetMapping("/section/{section}")
    public List<Ticket> getTicketsBySection(@PathVariable String section) {
        return ticketService.getTicketsBySection(section);
    }

    @DeleteMapping("/user/{userId}")
    public void removeUser(@PathVariable Long userId) {
        ticketService.removeUser(userId);
    }

    @PutMapping("/modify-seat/{ticketId}")
    public Ticket modifySeat(@PathVariable Long ticketId, @RequestParam String newSeatSection) {
        return ticketService.modifySeat(ticketId, newSeatSection);
    }
}
