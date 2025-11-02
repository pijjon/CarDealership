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
        Dealership dealership1 =  dealershipFileManager.getDealership();
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
        
    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }

    public int askUserInt(String question) {
        System.out.println(question);
        int response = scanner.nextInt();
        scanner.nextLine();
        return response;
    }


}
