package org.parkinglot.model;

import org.parkinglot.strategy.PricingStrategy;

public class EntryGate {

    private Vehicle vehicle;
    PricingStrategy pricingStrategy;

    public EntryGate(Vehicle vehicle, PricingStrategy pricingStrategy) {
        this.vehicle = vehicle;
        this.pricingStrategy = pricingStrategy;
    }

    public Ticket generateTicket() {
        return new Ticket(vehicle.getLicenseNumber());
    }

    public Invoice generateInvoice() {
        // Logic to generate and return an invoice based on vehicle details
        return new Invoice(pricingStrategy.getPrice(), vehicle.getLicenseNumber());
    }

    public void collectPayment() {

    }

    // Additional methods for entry gate functionality can be added here
}
