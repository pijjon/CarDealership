package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }

    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> filtered = this.inventory.stream()
                .filter(n -> n.getPrice() >= min && n.getPrice() <= max)
                .toList();

        return filtered;

    }

    public List<Vehicle> getVehiclesByMake(String make, String model) {
        List<Vehicle> filtered = this.inventory.stream()
                .filter(n -> n.getMake().contains(make))
                .filter(n -> n.getModel().contains(model))
                .toList();

        return filtered;
    }

    public List<Vehicle> getVehiclesByYear() {
        return this.inventory;
    }

    public List<Vehicle> getVehiclesByColor() {
        return this.inventory;
    }

    public List<Vehicle> getVehiclesByMileage() {
        return this.inventory;
    }

    public List<Vehicle> getVehiclesByType() {
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public void removeVehicle(String vehicle) {

    }
}
