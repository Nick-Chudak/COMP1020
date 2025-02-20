public class Schedule {
    private Stop[] stops;
    private String destination;

    public static void main(String[] args) throws BadScheduleException{
        // Stop stop1 = new Stop("Station A", "08:00", "08:15");
        // Stop stop2 = new Stop("Station B", "09:00", "09:15");
        // Stop stop3 = new Stop("Station C", "10:00", "10:15");
        // // Initialize Schedule with stops
        // Stop[] stops = { stop1, stop2, stop3 };
        // Schedule schedule = new Schedule(stops);
        
        // System.out.println(schedule.stops.length);
        // schedule.removeStop(3);
        
        // System.out.println(schedule.stops.length);
        // System.out.println(schedule.stops[0]);

        try {
            // Create Stop objects
            Stop stop1 = new Stop("Station A", "08:00", "08:15");
            Stop stop2 = new Stop("Station B", "09:00", "09:15");
            Stop stop3 = new Stop("Station C", "10:00", "10:15");
            // Initialize Schedule with stops
            Stop[] stops = { stop1, stop2, stop3 };
            Schedule schedule = new Schedule(stops);
            // Print initial schedule
            System.out.println("Initial Schedule:");
            System.out.println(schedule);
            /*
            * Expected output:
            * Schedule:
            * Destination: Station C
            * Stops:
            * 1. Stop Name: Station A, Arrival: 08:00, Departure: 08:15
            * 2. Stop Name: Station B, Arrival: 09:00, Departure: 09:15
            * 3. Stop Name: Station C, Arrival: 10:00, Departure: 10:15
            */
            // Add a new stop
            Stop stop4 = new Stop("Station D", "11:00", "11:15");
            schedule.addStop(stop4);
            System.out.println("\nAfter Adding Stop D:");
            System.out.println(schedule);
            /*
            * Expected output:
            * Success: Stop added.
            * Schedule:
            * Destination: Station D
            * Stops:
            * 1. Stop Name: Station A, Arrival: 08:00, Departure: 08:15
            * 2. Stop Name: Station B, Arrival: 09:00, Departure: 09:15
            * 3. Stop Name: Station C, Arrival: 10:00, Departure: 10:15
            * 4. Stop Name: Station D, Arrival: 11:00, Departure: 11:15
            */
            // Remove a stop
            schedule.removeStop(2); // Remove Station B
            System.out.println("\nAfter Removing Stop B:");
            System.out.println(schedule);
            /*
            * Expected output:
            * Success: Stop removed.
            * Schedule:
            * Destination: Station D
            * Stops:
            * 1. Stop Name: Station A, Arrival: 08:00, Departure: 08:15
            * 2. Stop Name: Station C, Arrival: 10:00, Departure: 10:15
            * 3. Stop Name: Station D, Arrival: 11:00, Departure: 11:15
            */
            // Invalid operations
            try {
                schedule.addStop(new Stop("Station E", "09:40", "10:10")); 
            } catch (Exception e) {
                System.out.println("Expected Exception: " + e.getMessage());
            }
            /*
            * Expected output:
            * Warning: Unable to update schedule. New stop times conflict with an
            existing
            * stop.
            */
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    public Schedule(String line) throws BadScheduleException, IllegalArgumentException {

        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("Input line cannot be null or empty");
        } else {
            String arrivalTime = null;
            String departureTime = null;
            String city = null;

            try {
                String[] listOfStops = line.split(",");

                for (int i = 0; i < listOfStops.length; i++) {
                    city = listOfStops[i].split(":")[0];
                    arrivalTime = listOfStops[i].split(":")[1].split("-")[0];
                    departureTime = listOfStops[i].split(":")[1].split("-")[1];
                }

                if (!Stop.isValidTime(arrivalTime) || !Stop.isValidTime(departureTime) || Stop.compareTimes(arrivalTime, departureTime) >= 0) {
                    throw new BadScheduleException("Invalid time sequence: Arrival time must be before departure time at " + city);
                }

            } catch (NullPointerException | ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid format: Stop must include a location and times");
            }
        }
    }

    public Schedule(Stop[] stops) throws IllegalArgumentException {
        this.stops = stops;
        this.destination = stops[stops.length - 1].getStationName();
    }

    public Stop[] getStops() {
        return this.stops;
    }

    public String getDestination() {
        return this.destination;
    }

    public void refreshDestination() {
        this.destination = this.stops[stops.length - 1].getStationName();
    }

    public void removeStop(int stopNumber) throws BadScheduleException {
        if (stopNumber < 1 || stopNumber > stops.length) {
            throw new BadScheduleException("Error: Stop number out of range");
        }

        this.stops = remove(this.stops, stopNumber);
        this.refreshDestination();

        System.out.println("Success: Stop removed.");
    }

    public boolean addStop(Stop newStop) throws BadScheduleException {
        try {
            this.stops = add(stops, newStop);

            this.refreshDestination();
            System.out.println("Success: Stop added.");
            return true;
        } catch (BadScheduleException e) {
            System.out.println("Warning: Unable to update schedule. New stop times conflict with an existing stop.");
            return false;
        }
    }

    public String toString() {
        String stopsFormatted = "";

        for (int i = 0; i < stops.length; i++) {
            stopsFormatted += String.valueOf(1 + i) + ". " + stops[i].toString() + "\n";
        }

        if (stopsFormatted.length() >= 1) {
            stopsFormatted = stopsFormatted.substring(0, stopsFormatted.length() - 1);
        }

        return "Schedule: " + "\n" + "Destination: " + this.getDestination() + "\n" + "Stops: " + "\n" + stopsFormatted;
    }

    private Stop[] remove(Stop[] oldStops, int stopNumber) {
        Stop[] newStops = new Stop[oldStops.length - 1]; 
        int index = stopNumber - 1;

        for (int i = 0, j = 0; i < oldStops.length; i++) {
           
            if (i != index) {
                newStops[j] = oldStops[i];
                j++;
            }
        }
        return newStops;
    }

    private Stop[] add(Stop[] oldStops, Stop newStop) throws BadScheduleException {
        boolean isAdded = false;
        Stop[] newStops = new Stop[oldStops.length + 1];
        int j = 0;

        for (int i = 0; i < oldStops.length; i++) {
            // If we haven't inserted yet and the new stop should be before oldStops[i]
            if (!isAdded && Stop.compareTimes(newStop.getArrivalTime(), oldStops[i].getArrivalTime()) < 0) {
                newStops[j++] = newStop; // Insert newStop at the correct position
                isAdded = true;
            }

            newStops[j++] = oldStops[i]; // Copy existing stops
        }

        // If newStop wasn't inserted inside the loop, append it at the end
        if (!isAdded) {
            newStops[j] = newStop;
        }

        return newStops;    
    }
}
