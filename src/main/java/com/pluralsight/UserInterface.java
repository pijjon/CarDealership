package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface() {
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership1 = dealershipFileManager.getDealership();
        this.dealership = dealership1;
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            vehicle.display();
        }
    }

    public void display() {
        init();
        while (true) {
            int response = askUserInt("""
                    1) Get By Price
                    2) Get By Make Model
                    3) Get By Year
                    4) Get By Color
                    5) Get By Mileage
                    6) Get By Vehicle Type
                    7) Get All Vehicles
                    8) Add a Vehicle
                    9) Remove a Vehicle
             
                    """);

            switch (response) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                default:
                    System.out.println("Invalid input, please try again");

            }
        }
    }

    public void processGetByPriceRequest() {

        double min = askUserInt("Please provide a minimum price to filter by:");
        double max = askUserInt("Please provide a maximum price to filter by:");

        displayVehicles(dealership.getVehiclesByPrice(min, max));

    }

    public void processGetByMakeModelRequest() {
        String responseMake = askUserStr("Please provide vehicle make to filter by: ");
        String responseModel = askUserStr("Please provide vehicle model to filter by: ");
        displayVehicles(dealership.getVehiclesByMake(responseMake, responseModel));
    }

    public void processGetByYearRequest() {
        int minYear = askUserInt("Please provide a minimum year to filter by: ");
        int maxYear = askUserInt("Please provide a maximum year to filter by: ");

        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
    }

    public void processGetByColorRequest() {
        String color = askUserStr("Please provide a color to filter by: ");

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest() {
        int minMileage = askUserInt("Please provide minimum mileage to filter by: ");
        int maxMileage = askUserInt("Please provide maximum mileage to filter by: ");

        displayVehicles(dealership.getVehiclesByMileage(minMileage, maxMileage));
    }

    public void processGetByVehicleTypeRequest() {
        String vehicleType = askUserStr("Please provide vehicle type to filter by: ");

        displayVehicles(dealership.getVehiclesByType(vehicleType));
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        Vehicle newVehicle = new Vehicle(
                askUserInt("Please provide a VIN number: "),
                askUserInt("Please provide the year of the vehicle: "),
                askUserStr("Please provide the make of the vehicle: "),
                askUserStr("Please provide the model of the vehicle: "),
                askUserStr("Please provide vehicle type of the vehicle: "),
                askUserStr("Please provide the color of the vehicle: "),
                askUserInt("Please provide the mileage of the vehicle: "),
                askUserDouble("Please provide a price for the vehicle: ")
        );

        dealership.addVehicle(newVehicle);
    }

    public void processRemoveVehicleRequest() {

    }

    public String askUserStr(String question) {
        try {
            System.out.println(question);
            String response = scanner.nextLine();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public int askUserInt(String question) {
        try {
            System.out.println(question);
            int response = scanner.nextInt();
            scanner.nextLine();
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public double askUserDouble(String question) {
        try {
            System.out.println(question);
            double response = scanner.nextDouble();
            scanner.nextLine();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}
