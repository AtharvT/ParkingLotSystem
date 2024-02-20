package org.parkinglot.model;

public class ParkingSpot {
    private int id; // Changed to int for better identification
    private double price;
    private Vehicle vehicle;
    private boolean isEmpty;

    public ParkingSpot(int id, double price) {
        this.id = id;
        this.price = price;
        this.isEmpty = true;
    }

    public boolean isAvailable() {
        return isEmpty;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        if (isEmpty) {
            this.vehicle = vehicle;
            this.isEmpty = false;
        } else {
            throw new RuntimeException("Parking is not available at this spot.");
        }
    }

    public void vacate() {
        isEmpty = true;
        vehicle = null; // Remove vehicle reference when spot is vacated
    }
}
