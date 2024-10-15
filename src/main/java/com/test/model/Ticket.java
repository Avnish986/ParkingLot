package com.test.model;

public class Ticket {

    private String ticketId;
    private Vehicle vehicle;
    private int floorNumber;
    private int slotNumber;

    public Ticket(String ticketId, Vehicle vehicle, int floorNumber, int slotNumber) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
