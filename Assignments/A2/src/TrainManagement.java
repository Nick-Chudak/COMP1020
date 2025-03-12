/**
 * Name of class or program (matches filename)
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 2, question 5
 * @author       Mykola Chudak, 8043157
 * @version      2/20/2025
 */

import java.io.*;

public class TrainManagement {
    private Train[] trains;
    private static TrainManagement instance;
    private static String OUTPUT;
    
    private TrainManagement() {
        trains = new Train[0];
    }

    public static TrainManagement getInstance() {
        if (instance == null) {
            instance = new TrainManagement();
        }
        return instance;
    }

    public static TrainManagement fireManagement() {
        instance = new TrainManagement();
        return instance;
    }

   public Train[] getTrains() {
        return trains;
    }

    public Train findTrainByName(String trainName) {
        for (Train train : trains) {
            if (train.getName().equals(trainName)) {
                return train;
            }
        }
        return null;
    }

    private void addTrain(Train train) {
        Train[] newTrains = new Train[trains.length + 1];
        for (int i = 0; i < trains.length; i++) {
            newTrains[i] = trains[i]; // Manual copy of array elements
        }
        newTrains[trains.length] = train; // Add the new train at the end
        trains = newTrains;
    }

    public void processTrainSchedule(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split(";", 2); // Ensure only two parts are split
                    if (parts.length != 2 || parts[0].isBlank() || parts[1].isBlank()) {
                        System.out.println("Error processing line: empty");
                        continue;
                    }
    
                    String name = parts[0].trim();
                    String schedule = parts[1].trim();
    
                    Schedule trainSchedule = new Schedule(schedule);
                    Train train = new Train(name, trainSchedule);
                    addTrain(train);
                } catch (IllegalArgumentException | BadTrainException | BadScheduleException e) {
                    System.out.println("Error processing line: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new IOException("Error reading schedule file: " + e.getMessage());
        }
    }

    public void removeStopFromTrainSchedule(String trainName, int stopNumber) {
        Train train = findTrainByName(trainName);
        if (train == null) {
            System.out.println("Failed to remove stop: Train " + trainName + " not found.");
            return;
        }
        try {
            train.removeStopFromTrainSchedule(stopNumber);
            System.out.println("Stop removed successfully for " + trainName);
        } catch (BadScheduleException e) {
            System.out.println("Failed to remove stop for " + trainName + ": " + e.getMessage());
        }
    }

    public void addStopToTrainSchedule(String trainName, String stationName, String arrivalTime, String departureTime) {
        Train train = findTrainByName(trainName);
        if (train == null) {
            System.out.println("Failed to add schedule: Train " + trainName + " not found.");
            return;
        }
        try {
            Stop stop = new Stop(stationName, arrivalTime, departureTime);
            train.addStopToTrainSchedule(stop);
            System.out.println("Stop added successfully for " + trainName);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to add stop for " + trainName + ": " + e.getMessage());
        } catch (BadScheduleException e) {
            System.out.println("Failed to add stop for " + trainName + ": " + e.getMessage());
        }
    }

    public void addPassenger(String trainName, int carPosition, int seatNum, int luggageWeight) {
        Train train = findTrainByName(trainName);
        if (train == null) {
            System.out.println("Failed to add passenger: Train " + trainName + " not found");
            return;
        }
        try {
            train.addPassenger(carPosition, seatNum, luggageWeight);
            System.out.println("Passenger added successfully for " + trainName);
        } catch (BadTrainException e) {
            System.out.println("Failed to add passenger for " + trainName + ": " + e.getMessage());
        }
    }

    public void removePassenger(String trainName, int carPosition, int seatNum) {
        Train train = findTrainByName(trainName);
        if (train == null) {
            System.out.println("Failed to remove passenger: Train " + trainName + " not found.");
            return;
        }
        try {
            train.removePassenger(carPosition, seatNum);
            System.out.println("Passenger removed successfully for " + trainName);
        } catch (BadTrainException e) {
            System.out.println("Failed to remove passenger for " + trainName + ": " + e.getMessage());
        }
    }

    public void printTrainSeating(String trainName) {
        Train train = findTrainByName(trainName);
        if (train != null) {
            System.out.println(train.seatingPlanTrain());
        } else {
            System.out.println("");
        }
    }

    public String toString() {
        String result = "Train Management:\n===============================\n";
        for (Train train : trains) {
            result += train.toString() + "\n";
            for (int i = 0; i < train.getCars().length; i++) {
                result += train.getCarByIndex(i).toString() + "\n";
            }
            result += "-------------------------------\n";
        }
        return result;
    }
    

    public void writeTrainManagementToFile() throws IOException {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(OUTPUT))) {
            wr.write(toString());
        } catch (IOException e) {
            throw new IOException("Error writing to AllTrains.txt: " + e.getMessage());
        }
    }
}
