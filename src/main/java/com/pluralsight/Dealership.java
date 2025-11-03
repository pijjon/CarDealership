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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> filtered = this.inventory.stream()
                .filter(n -> n.getYear() >= minYear && n.getYear() <= maxYear)
                .toList();

        return filtered;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> filtered = this.inventory.stream()
                .filter(n -> n.getColor().contains(color))
                .toList();

        return filtered;
    }

    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        List<Vehicle> filtered = this.inventory.stream()
                .filter(n -> n.getOdometer() >= minMileage && n.getOdometer() <= maxMileage)
                .toList();

        return filtered;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> filtered = this.inventory.stream()
                .filter(n -> n.getVehicleType().equals(vehicleType))
                .toList();

        return filtered;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public void removeVehicle(int vin) {
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getVin() == vin) {
                this.inventory.remove(vehicle);
                return;
            }
        }
    }
}
