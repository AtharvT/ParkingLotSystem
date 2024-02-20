package org.parkinglot.system;

import org.parkinglot.model.ParkingSpot;
import org.parkinglot.model.Vehicle;
import org.parkinglot.strategy.ParkingLotStrategy;
import org.parkinglot.strategy.PricingStrategy;

import java.util.List;

public class ParkingLotSystem {
    private static ParkingLotSystem parkingLotSystem;
    private final List<ParkingSpot> parkingSpotList;
    private final ParkingLotStrategy parkingLotStrategy; // Ensure final to enforce immutability

    private final PricingStrategy pricingStrategy;

    private ParkingLotSystem(ParkingLotStrategy parkingLotStrategy, List<ParkingSpot> parkingSpotList, PricingStrategy pricingStrategy) {
        this.parkingLotStrategy = parkingLotStrategy;
        this.parkingSpotList = parkingSpotList;
        this.pricingStrategy = pricingStrategy;
    }

    public static ParkingLotSystem getInstance(ParkingLotStrategy parkingLotStrategy, List<ParkingSpot> parkingSpotList, PricingStrategy pricingStrategy) {
        if (parkingLotSystem.parkingLotStrategy == null) {
            return new ParkingLotSystem(parkingLotStrategy, parkingSpotList, pricingStrategy);
        }
        return parkingLotSystem;
    }

    public void park(Vehicle vehicle) {
        if (parkingLotStrategy != null) {
            parkingLotStrategy.park(vehicle);
        } else {
            throw new IllegalStateException("Parking lot strategy is not set.");
        }
    }

    public void unpark(ParkingSpot parkingSpot) {
        if (parkingLotStrategy != null) {
            parkingLotStrategy.unpark(parkingSpot);
        } else {
            throw new IllegalStateException("Parking lot strategy is not set.");
        }
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }
    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }
}
