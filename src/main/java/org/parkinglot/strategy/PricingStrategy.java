package org.parkinglot.strategy;

import org.parkinglot.model.ParkingSpot;
import org.parkinglot.model.VehicleType;

public interface PricingStrategy {

    public double getPrice();
}
