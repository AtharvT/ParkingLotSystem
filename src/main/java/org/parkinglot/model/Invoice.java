package org.parkinglot.model;

import java.util.UUID;

public class Invoice {
    private final UUID uuid;
    private final double price;
    private final String vehicleNumber;

    public Invoice(double price, String vehicleNumber) {
        this.uuid = UUID.randomUUID();
        this.price = price;
        this.vehicleNumber = vehicleNumber;
    }

    public UUID getUuid() {
        return uuid;
    }

    public double getPrice() {
        return price;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}
