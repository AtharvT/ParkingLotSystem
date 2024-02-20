package org.parkinglot.strategy;

import org.parkinglot.model.ParkingSpot;
import org.parkinglot.model.Vehicle;

public interface ParkingLotStrategy {

    public void park(Vehicle vehicle);
    public void unpark(ParkingSpot parkingSpot);
}
