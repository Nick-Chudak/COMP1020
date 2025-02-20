import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Train {
    private String name;
    private Car[] cars;
    private Schedule schedule;

    public static void main(String[] args) {
        try {
           // Create Stop objects for the Schedule
           Stop stop1 = new Stop("Station A", "08:00", "08:15");
           Stop stop2 = new Stop("Station B", "09:00", "09:15");
           Stop stop3 = new Stop("Station C", "10:00", "10:15");
           Stop[] stops = { stop1, stop2, stop3 };
     
           // Create a Schedule object
           Schedule schedule = new Schedule(stops);
     
           // Define seating layouts for cars
           String layout1 = "| O X |\n| X O |";
           String layout2 = "| O O |\n| X X |";
           String layout3 = "| O O |\n| O O |";
     
           // Define seating lists (true for occupied 'X', false for available 'O')
           boolean[] seatingList1 = { false, true, true, false };
           boolean[] seatingList2 = { false, false, true, true };
           boolean[] seatingList3 = { false, false, false, false };
     
           // Create Car objects
           Car car1 = new Car(1, 100, seatingList1, layout1); // Car 1: 100kg luggage capacity
           Car car2 = new Car(2, 80, seatingList2, layout2); // Car 2: 80kg luggage capacity
           Car car3 = new Car(3, 120, seatingList3, layout3); // Car 3: 120kg luggage capacity
           Car[] cars = { car1, car2, car3 };
        
           Train train = new Train("Express Line", cars, schedule);
     
           // Print initial train details
           System.out.println("Initial Train Details:");
           System.out.println(train);
           /*
              * Expected output:
              * Train Name: Express Line
              * Number of cars: 3
              * Schedule:
              * Destination: Station C
              * Stops:
              * 1. Stop Name: Station A, Arrival: 08:00, Departure: 08:15
              * 2. Stop Name: Station B, Arrival: 09:00, Departure: 09:15
              * 3. Stop Name: Station C, Arrival: 10:00, Departure: 10:15
              */
     
           // Add a passenger
           System.out.println("\nAdding a passenger to Car 1, Seat 1, with 20kg luggage:");
           train.addPassenger(1, 1, 20);
           /*
              * Expected output:
              * Success: Passenger successfully added to car 1, seat 1 with luggage weight
              * 20kg
              */
     
           // Attempt to add another passenger to the same seat
           System.out.println("\nAttempting to add a passenger to Car 1, Seat 1 again:");
           train.addPassenger(1, 1, 10);
           /*
              * Expected output:
              * Seat 1 in car 1 is already reserved
              */
     
           // Add a passenger with excess luggage
           System.out.println("\nAdding a passenger to Car 1, Seat 4, with 90kg luggage:");
           train.addPassenger(1, 4, 90);
           /*
              * Expected output:
              * Seat 4 in car 1 reserved, but no space for luggage. Searching for another
              * car...
              * Success: Luggage stored in car 2
              */
     
           // Adding a new stop 'Station B1' between Station B and Station C
           System.out.println("\nAdding a new stop 'Station B1' between Station B and Station C:");
           train.addStopToTrainSchedule(new Stop("Station B1", "09:30", "09:45"));
           System.out.println(train);
           /*
              * Expected output:
              * Success: Stop added.
              * Schedule:
              * Destination: Station C
              * Stops:
              * 1. Stop Name: Station A, Arrival: 08:00, Departure: 08:15
              * 2. Stop Name: Station B, Arrival: 09:00, Departure: 09:15
              * 3. Stop Name: Station B1, Arrival: 09:30, Departure: 09:45
              * 4. Stop Name: Station C, Arrival: 10:00, Departure: 10:15
              */
     
           // Remove a stop from the schedule
           System.out.println("\nRemoving Station B from the schedule:");
           train.removeStopFromTrainSchedule(2);
           System.out.println(train);
           /*
              * Expected output:
              * Success: Stop removed.
              * Updated train details with Station B removed from the schedule.
              */
     
           // Write train details to file
           System.out.println("\nWriting train details to file");
           train.writeToFile();
           /*
              * Expected output:
              * None
              * (Train details written to "Express Lineupdated.txt")
              */
     
        } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
        }
    }

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
            
            if (!trainName.equals(this.name) || !trainName.equals(trainFile.substring(0, (trainName.length() - ".txt".length())))) {
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

