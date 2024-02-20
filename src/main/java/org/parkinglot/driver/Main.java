package org.parkinglot.driver;

import org.parkinglot.model.*;
import org.parkinglot.strategy.FixedPricingStrategy;
import org.parkinglot.strategy.NearestParkingSpotStrategy;
import org.parkinglot.strategy.ParkingLotStrategy;
import org.parkinglot.strategy.PricingStrategy;
import org.parkinglot.system.ParkingLotSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is a Parking Slot");

        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        parkingSpotList.add(new ParkingSpot(1,10.0));
        parkingSpotList.add(new ParkingSpot(2, 20.0));
        parkingSpotList.add(new ParkingSpot(3, 30.0));

        ParkingLotStrategy parkingLotStrategy = new NearestParkingSpotStrategy(parkingSpotList);
        PricingStrategy pricingStrategy = new FixedPricingStrategy();

        ParkingLotSystem parkingLotSystem = ParkingLotSystem.getInstance(parkingLotStrategy, parkingSpotList, pricingStrategy);

        Vehicle vehicle = new Vehicle("12345", VehicleType.SMALL);
        Vehicle mediumVehicle = new Vehicle("12346", VehicleType.MEDIUM);
        Vehicle largeVehicle = new Vehicle("12347", VehicleType.LARGE);

        EntryGate entryGate = new EntryGate(vehicle, parkingLotSystem.getPricingStrategy());

        parkingLotSystem.park(vehicle);
        parkingLotSystem.park(mediumVehicle);
        parkingLotSystem.park(largeVehicle);

        parkingLotSystem.unpark(parkingLotSystem.getParkingSpotList().get(0));

        ExitGate exitGate = new ExitGate(vehicle);
    }
}
