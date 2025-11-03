package com.pluralsight;

import java.io.*;


public class DealershipFileManager {

    public static Dealership getDealership() {
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {

            // getter header from csv file to input into Dealership constructor
            String[] dealershipParts = reader.readLine().split("\\|");
            Dealership dealership = new Dealership(dealershipParts[0], dealershipParts[1], dealershipParts[2]);

            String nextLine;

            // loop to get all vehicle data
            while ((nextLine = reader.readLine()) != null) {
                Vehicle vehicle = getVehicle(nextLine);

                dealership.addVehicle(vehicle);
            }
            return dealership;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Vehicle getVehicle(String nextLine) {
        String[] vehicleParts = nextLine.split("\\|");

        // build the vehicle
        Vehicle vehicle = new Vehicle(
                Integer.parseInt(vehicleParts[0]),
                Integer.parseInt(vehicleParts[1]),
                vehicleParts[2],
                vehicleParts[3],
                vehicleParts[4],
                vehicleParts[5],
                Integer.parseInt(vehicleParts[6]),
                Double.parseDouble(vehicleParts[7]));
        return vehicle;
    }

    public static void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv"))) {
            //write the dealership header
            writer.write(String.format("%s|%s|%s", dealership.getName(), dealership.getAddress(), dealership.getPhone()));
            writer.newLine();
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                // write new line
                writer.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice()
                ));
                writer.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}
