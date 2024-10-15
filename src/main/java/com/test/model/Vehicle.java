package com.test.model;

public class Vehicle {
    String registrationNumber;
    String color;
    String type;

    public Vehicle(String registrationNumber, String color, String type) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
}
