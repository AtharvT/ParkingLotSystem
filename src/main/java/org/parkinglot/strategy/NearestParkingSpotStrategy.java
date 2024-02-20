package org.parkinglot.strategy;

import org.parkinglot.model.ParkingSpot;
import org.parkinglot.model.Vehicle;

import java.util.List;

public class NearestParkingSpotStrategy implements ParkingLotStrategy {

    private List<ParkingSpot> parkingSpotList;

    public NearestParkingSpotStrategy(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    @Override
    public void park(Vehicle vehicle) {
        if (parkingSpotList == null || parkingSpotList.isEmpty()) {
            throw new IllegalStateException("Parking spot list is not initialized or empty.");
        }

        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (parkingSpot.isAvailable()) {
                parkingSpot.parkVehicle(vehicle);
                return; // Parked the vehicle, so exit loop
            }
        }
        throw new RuntimeException("No available parking spot found.");
    }

    @Override
    public void unpark(ParkingSpot parkingSpot) {
        parkingSpot.vacate();
    }
}