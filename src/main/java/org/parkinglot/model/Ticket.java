package org.parkinglot.model;

import java.util.UUID;

public class Ticket {
    UUID uuid;
    private String vehicleNumber;


    public Ticket(String vehicleNumber) {
        this.uuid = UUID.randomUUID();
        this.vehicleNumber = vehicleNumber;
    }
}
