package com.test.model;

public class ParkingSlot {

    public int slotNumber;
     boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSlot(int parkingSlotId) {
        this.slotNumber = parkingSlotId;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void unpark() {
        this.vehicle = null;
        this.isOccupied = false;
    }
}
