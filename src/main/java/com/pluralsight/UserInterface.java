package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    public static Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership1 =  dealershipFileManager.getDealership();
        this.dealership = dealership1;
    }

    public void display() {

    }

    public void processGetByPriceRequest() {

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
