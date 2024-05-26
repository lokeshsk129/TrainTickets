package com.Ticket.demo;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@lombok.Getter
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromLocation;
    private String toLocation;
    private double price;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String seatSection;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSeatSection(String seatSection) {
        this.seatSection = seatSection;
    }


}