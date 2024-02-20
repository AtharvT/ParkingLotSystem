package org.parkinglot.model;

public class ExitGate {
    private Vehicle vehicle;
    private Ticket ticket;

    public ExitGate(Vehicle vehicle, Ticket ticket) {
        this.vehicle = vehicle;
        this.ticket = ticket;
    }

    public void returnTicket() {
        if (ticket != null) {
            ticket = null;
            // Additional logic for releasing parking space or updating ticket status
        } else {
            // Handle case where there's no ticket associated with the vehicle
            System.out.println("No ticket associated with the vehicle.");
        }
    }

    // Getter and setter methods for vehicle and ticket attributes (if needed)
}
