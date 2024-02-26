package com.driver;

import java.util.List;
import java.util.Scanner;


public class HydroInfoController {
    private HydroInfoService hydroInfoService;

    public HydroInfoController(HydroInfoService hydroInfoService) {
        this.hydroInfoService = hydroInfoService;
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    storeWaterLevel(scanner);
                    break;
                case 2:
                    displayAllWaterLevels();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Store Water Level Data");
        System.out.println("2. Display All Water Levels");
        System.out.println("3. Exit");
    }

    private void storeWaterLevel(Scanner scanner) {
        System.out.println("Enter Site Name:");
        scanner.nextLine(); // Consume the newline character
        String siteName = scanner.nextLine();

        double waterLevel = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Enter Water Level:");

            if (scanner.hasNextDouble()) {
                waterLevel = scanner.nextDouble();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid numeric water level.");
                scanner.next(); // Consume the invalid input
            }
        }
        WaterLevelDTO waterLevelDTO = new WaterLevelDTO(siteName, waterLevel);
        hydroInfoService.storeWaterLevelData(waterLevelDTO);
        System.out.println("Water Level Data for site '" + siteName + "' stored successfully.");
    }


    private void displayAllWaterLevels() {
        System.out.println("All Water Levels:");
        List<WaterLevel> waterLevels = hydroInfoService.getAllWaterLevels();

        if (waterLevels.isEmpty()) {
            System.out.println("No water level data available.");
        } else {
            for (WaterLevel waterLevel : waterLevels) {
                System.out.println("Site: " + waterLevel.getSiteName() + ", Water Level: " + waterLevel.getWaterLevel());
            }
        }
    }

    public static void main(String[] args) {
        // Create necessary objects and start the application
        WaterLevelDataRepository repository = new WaterLevelDataRepository();
        HydroInfoService hydroInfoService = new HydroInfoService(repository);
        HydroInfoController hydroInfoController = new HydroInfoController(hydroInfoService);

        // Start processing user input
        hydroInfoController.processUserInput();
    }
}