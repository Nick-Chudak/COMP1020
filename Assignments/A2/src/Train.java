/**
 * Name of class or program (matches filename)
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 2, question 4
 * @author       Mykola Chudak, 8043157
 * @version      2/20/2025
 */


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Train {
    private String name;
    private Car[] cars;
    private Schedule schedule;

    public Train(String name, Schedule schedule) throws IllegalArgumentException, IOException, BadTrainException {

        if (name == null || name.isBlank() || schedule == null) {
            throw new IllegalArgumentException("Train name/schedule can not be null or empty");
        }

        this.name = name;
        this.schedule = schedule;
        this.processTrainFile(this.name + ".txt");
    }

    public Train(String name, Car[] cars, Schedule schedule) throws IllegalArgumentException {

        if (name == null || name.isBlank() || schedule == null) {
            throw new IllegalArgumentException("Train name/schedule can not be null or empty");
        }

        if (cars == null || cars.length == 0) {
            throw new IllegalArgumentException("Train cars can not be null or empty");
        }

        this.name = name;
        this.cars = cars;
        this.schedule = schedule;
    }

    public String getName() {
        return this.name;
    }

    public String getDestination() {
        return this.schedule.getDestination();
    }

    public Stop[] getStops() {
        return this.schedule.getStops();
    }

    public Car getCarByIndex(int index) {
        return this.cars[index];
    }

    public Car[] getCars() {
        return this.cars;
    }
    public boolean addPassenger(int carPosition, int seatNum, int luggageWeight) throws BadTrainException {
        int result;

        if ((carPosition < 1) && (carPosition > cars.length)) {
            throw new BadTrainException("Error: Invalid car number: " + carPosition);
        }

        result = cars[carPosition - 1].reserveSeat(seatNum, luggageWeight);

        if (result == 1) {
            System.out.println("Seat " + seatNum + " in car " + carPosition + " is already reserved");
            return false;
        }

        if (result == 2) {
            System.out.println("Seat " + seatNum + " in car " + carPosition + " reserved, but no space for luggage. Searching for another car...");
            for (int i = 0; i < cars.length; i++) {
                if (cars[i].canAddLuggage(luggageWeight) == true) {
                    cars[i].addLuggage(luggageWeight);
                    System.out.println("Success: Luggage stored in car " + (i + 1));
                    return true;
                }
            } 
            System.out.println("No car has space for the luggage. I guess it's left behind...");
        } else {
            System.out.println("Success: Passenger successfully added to car " + carPosition + ", seat " + seatNum + " with luggage weight " + luggageWeight + "kg");
        }
        return true;
    }

    public void removePassenger(int carPosition, int seatNum) throws BadTrainException {
        if ((carPosition < 1) && (carPosition > cars.length)) {
            throw new BadTrainException("Error: Invalid car number: " + carPosition);
        }

        cars[carPosition - 1].cancelReservation(seatNum);
        System.out.println("Success: Passenger removed from car " + carPosition + ", seat " + seatNum);
    }

    public void removeStopFromTrainSchedule(int stopNumber) throws BadScheduleException {
        this.schedule.removeStop(stopNumber);
    }

    public boolean addStopToTrainSchedule(Stop newStop) throws BadScheduleException {
        return this.schedule.addStop(newStop);
    }

    public void processTrainFile(String trainFile) throws IOException, BadTrainException, IllegalArgumentException {
        String trainName;
        String carCountLine;
        int numberOfCars;
        String line;
        int carIndex = 0;
        String carDescription = "";


        try (BufferedReader reader = new BufferedReader(new FileReader(trainFile))) {
            trainName = reader.readLine().substring("Train Name: ".length());
            
            if (!trainName.equals(this.name)) {
                throw new BadTrainException("Train name in file does not match file name: " + trainName);
            }

            carCountLine = reader.readLine();

            try {
                numberOfCars = Integer.parseInt(carCountLine.substring("Cars: ".length()));
            } catch (NumberFormatException e) {
                throw new BadTrainException("Car number must be an integer");
            }

            cars = new Car[numberOfCars];

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Car: ")) {
                    carDescription = line + "\n"; // Reset description for new car
                } else if (line.startsWith("Luggage Weight: ")) {
                    carDescription += line;
                    cars[carIndex++] = new Car(carDescription);
                } else if (!line.trim().isEmpty()) {
                    carDescription += line + "\n";
                }
            }

            if (carIndex != numberOfCars) {
                throw new BadTrainException("Wrong number of cars");
            }
        } catch (IOException e) {
            throw new IOException("Error reading file: " + e.getMessage(), e);
        }
    }

    public String toString() {
        return "Train Name: " + name + "\nNumber of cars: " + cars.length + "\n" + schedule.toString();
    }

    public String seatingPlanTrain() {
        String result = "";

        for (Car el : cars) {
            result += el.toString() + "\n";
        }

        return result;
    }

    public void writeToFile() throws IOException {
        String fileName = this.name + "updated.txt";

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(this.toString() + "\n\n");
            for (Car car : cars) {
                fw.write(car.toString() + "\n\n");
            }
        } catch (IOException e) {
            throw new IOException("Error writing to file: " + e.getMessage(), e);
        }
    }
}

