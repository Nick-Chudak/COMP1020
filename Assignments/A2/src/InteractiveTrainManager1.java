/**
 * File: InteractiveTrainManager.java
 * Date: 31-01-2025
 * Copyright: © 2025 University of Manitoba
 * License: All rights reserved.
 *
 * Description:
 *     This class provides an interactive command-line interface (CLI) for managing train schedules,
 *     passenger assignments, and train stops.
 *
 * Features:
 *     - Loads train schedules from a file.
 *     - Adds and removes passengers from train cars.
 *     - Adds and removes stops in train schedules.
 *     - Displays train schedules and seating plans.
 *     - Saves train data to a file upon program termination.
 *
 * Commands:
 *     - load: Loads a train schedule from a file.
 *     - addpassenger: Adds a passenger to a specified train and seat.
 *     - removepassenger: Removes a passenger from a specified train and seat.
 *     - addstop: Adds a stop to a train schedule.
 *     - removestop: Removes a stop from a train schedule.
 *     - printall: Displays all train schedules.
 *     - printseating: Displays the seating arrangement for a specific train.
 *     - quit: Exits the program and saves data to a file.
 *
 * Usage:
 *     Run the program and enter commands in the terminal as prompted.
 * 
 * Example:
 *     > load
 *     Enter the schedule file name: schedule.txt
 *     Schedule file found successfully.
 *
 * Disclaimer:
 *     This code is intended for educational purposes only and is part of COMP 1020 at the 
 *     University of Manitoba.
 */

import java.io.IOException;
import java.util.Scanner;

public class InteractiveTrainManager {
    
    public static void main(String[ ] args) {
        Scanner scanner = new Scanner(System.in);
        TrainManagement trainManagement = TrainManagement.getInstance();

        String command = "";
        while (!command.equals("quit")) {
            
            System.out.println("\nAvailable commands:");
            System.out.println("load - Load a schedule file");
            System.out.println("addpassenger - Add a passenger");
            System.out.println("removepassenger - Remove a passenger");
            System.out.println("removestop - Remove stop from train schedule");
            System.out.println("addstop - Add stop to train schedule");
            System.out.println("printall - Print all trains");
            System.out.println("printseating - Print seating plan for a train");
            System.out.println("quit - Exit the program");
            System.out.print("Enter a command: ");

            command = scanner.nextLine();

            if (command.equals("load")) {
                
                System.out.print("Enter the schedule file name: ");
                String fileName = scanner.nextLine();
                try {
                    trainManagement.processTrainSchedule(fileName);
                    System.out.println("Schedule file found successfully.");
                } catch (IOException e) {
                    System.out.println("Error loading schedule file: " + e.getMessage());
                }
            } else if (command.equals("addpassenger")) {
                
                System.out.print("Enter train name: ");
                String trainName = scanner.nextLine();
                System.out.print("Enter car number: ");
                int carNum = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter seat number: ");
                int seatNum = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter luggage weight: ");
                int luggageWeight = Integer.parseInt(scanner.nextLine());
                trainManagement.addPassenger(trainName, carNum, seatNum, 
                luggageWeight);

            } else if (command.equals("removepassenger")) {
                
                System.out.print("Enter train name: ");
                String trainName = scanner.nextLine();
                System.out.print("Enter car number: ");
                int carNum = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter seat number: ");
                int seatNum = Integer.parseInt(scanner.nextLine());
                trainManagement.removePassenger(trainName, carNum, seatNum);

            } else if (command.equals("removestop")) {
                
                System.out.print("Enter train name: ");
                String trainName = scanner.nextLine();
                System.out.print("Enter stop number: ");
                int stopNumber = Integer.parseInt(scanner.nextLine());
                trainManagement.removeStopFromTrainSchedule(trainName, stopNumber);

            } else if (command.equals("addstop")) {
                
                System.out.print("Enter train name: ");
                String trainName = scanner.nextLine();
                System.out.print("Enter stop details (Location:arrival-departure): ");
                System.out.print("Enter station name: ");
                String stationName = scanner.nextLine();
                System.out.print("Enter arrival time (HH:mm): ");
                String arrivalTime = scanner.nextLine();
                System.out.print("Enter departure time (HH:mm): ");
                String departureTime = scanner.nextLine();
                trainManagement.addStopToTrainSchedule(trainName, stationName, arrivalTime, departureTime);

            } else if (command.equals("printall")) {
                
                System.out.println(trainManagement.toString());

            } else if (command.equals("printseating")) {
                
                System.out.print("Enter train name: ");
                String trainName = scanner.nextLine();
                trainManagement.printTrainSeating(trainName);

            } else if (!command.equals("quit")) {
                
                System.out.println("Invalid command. Please try again.");
                
            }
        }

        scanner.close();
        System.out.println("Have a good day!");

        try {
            trainManagement.writeTrainManagementToFile();
            for(Train train: trainManagement.getTrains()) {
                train.writeToFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}

