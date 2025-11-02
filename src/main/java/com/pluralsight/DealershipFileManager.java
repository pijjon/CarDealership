package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DealershipFileManager {

    public static void getDealership() {
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

    private static void saveDealership() {

    }
}
