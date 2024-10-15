package com.test.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    String parkingLotId;
    List<ParkingFloor> floors;
    Map<String, Ticket> ticketMap;


    public ParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        floors = new ArrayList<>();
        ticketMap = new HashMap<>();
        for (int i = 1; i <= noOfFloors; i++) {
            floors.add(new ParkingFloor(i, noOfSlotsPerFloor));
        }
    }

    public String parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSlot slot = floor.findAvailableSlot(vehicle.getType());
            if (slot != null) {
                slot.park(vehicle);
                String ticketId = generateTicketId(floor.floorNumber, slot.slotNumber);
                Ticket ticket = new Ticket(ticketId, vehicle, floor.floorNumber, slot.slotNumber);
                ticketMap.put(ticketId, ticket);
                return ticketId;
            }
        }
        return "Parking Lot Full";
    }

    public String unparkVehicle(String ticketId) {
        Ticket ticket = ticketMap.get(ticketId);
        if (ticket == null) {
            return "Invalid Ticket";
        }
        ParkingFloor floor = floors.get(ticket.getFloorNumber() - 1);
        ParkingSlot slot = floor.carSlots.stream()
                .filter(s -> s.slotNumber == ticket.getSlotNumber())
                .findFirst()
                .orElse(null);
        if (slot != null) {
            slot.unpark();
            ticketMap.remove(ticketId);
            return String.format("Unparked vehicle with Registration Number: %s and Color: %s",
                    ticket.getVehicle().registrationNumber, ticket.getVehicle().color);
        }
        return "Invalid Ticket";
    }

    private String generateTicketId(int floorNumber, int slotNumber) {
        return parkingLotId + "_" + floorNumber + "_" + slotNumber;
    }
}
