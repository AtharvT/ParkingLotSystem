package org.parkinglot.strategy;

import org.parkinglot.model.VehicleType;

public class FixedPricingStrategy implements PricingStrategy {
    @Override
    public double getPrice(VehicleType vehicleType) {
        switch (vehicleType) {
            case SMALL:
                return 100;
            case MEDIUM:
                return 200;
            case LARGE:
                return 300;
            default:
                throw new IllegalArgumentException("Unsupported vehicle type: " + vehicleType);
        }
    }
}
