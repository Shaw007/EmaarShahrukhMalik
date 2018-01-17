package com.srmstudios.emaarshahrukhmalik.ui.adapter.model;

import java.util.List;

/**
 * Created by Shahrukh Malik on 12/29/2017.
 */

public class TotalTicketPurchase {
    private String visitorType;
    private List<Ticket> tickets;

    public TotalTicketPurchase(String visitorType, List<Ticket> tickets) {
        this.visitorType = visitorType;
        this.tickets = tickets;
    }

    public String getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(String visitorType) {
        this.visitorType = visitorType;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
