package com.pluralsight;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public void display() {
        System.out.printf("""
                VIN: %d
                Vehicle Type: %s
                Make/Model: %s %s %s
                Miles: %d
                Price: %.2f
                
                """,
                this.vin,
                this.vehicleType,
                this.color,
                this.make,
                this.model,
                this.odometer,
                this.price);
    }
}
