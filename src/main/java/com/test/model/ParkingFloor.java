package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    int floorNumber;
    List<ParkingSlot> carSlots;
    List<ParkingSlot> bikeSlots;
    List<ParkingSlot> truckSlots;

    public ParkingFloor(int floorNumber, int noOfSlots) {
        this.floorNumber = floorNumber;
        carSlots = new ArrayList<>();
        bikeSlots = new ArrayList<>();
        truckSlots = new ArrayList<>();
        initializeSlots(noOfSlots);
    }

    private void initializeSlots(int noOfSlots) {
        truckSlots.add(new TruckSlot(1));
        for (int i = 2; i <= 3; i++) {
            bikeSlots.add(new BikeSlot(i));
        }
        for (int i = 4; i <= noOfSlots; i++) {
            carSlots.add(new CarSlot(i));
        }
    }

    public ParkingSlot findAvailableSlot(String vehicleType) {
        switch (vehicleType) {
            case "Truck":
                return truckSlots.stream().filter(slot -> !slot.isOccupied).findFirst().orElse(null);
            case "Bike":
                return bikeSlots.stream().filter(slot -> !slot.isOccupied).findFirst().orElse(null);
            case "Car":
                return carSlots.stream().filter(slot -> !slot.isOccupied).findFirst().orElse(null);
            default:
                return null;
        }
    }
}
