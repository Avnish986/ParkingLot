package com.test;

import com.test.model.*;


public class Main {
    ParkingLot parkingLot;
    public void processCommand(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "create_parking_lot":
                createParkingLot(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                break;
            case "park_vehicle":
                parkVehicle(parts[1], parts[2], parts[3]);
                break;
            case "unpark_vehicle":
                unparkVehicle(parts[1]);
                break;
            case "display":
                // handle display cases here
                break;
            case "exit":
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid Command");
        }
    }

    private void parkVehicle(String vehicleType, String regNo, String color) {
        Vehicle vehicle;
        switch (vehicleType) {
            case "Car":
                vehicle = new Car(regNo, color);
                break;
            case "Bike":
                vehicle = new Bike(regNo, color);
                break;
            case "Truck":
                vehicle = new Truck(regNo, color);
                break;
            default:
                System.out.println("Invalid vehicle type");
                return;
        }
        String ticketId = parkingLot.parkVehicle(vehicle);
        if (ticketId.equals("Parking Lot Full")) {
            System.out.println("Parking Lot Full");
        } else {
            System.out.println("Parked vehicle. Ticket ID: " + ticketId);
        }
    }

    private void createParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
        parkingLot = new ParkingLot(parkingLotId, noOfFloors, noOfSlotsPerFloor);
        System.out.println("Created parking lot with " + noOfFloors + " floors and " + noOfSlotsPerFloor + " slots per floor");
    }

    private void unparkVehicle(String ticketId) {
        String result = parkingLot.unparkVehicle(ticketId);
        System.out.println(result);
    }

    public static void main(String[] args) {

    }
}