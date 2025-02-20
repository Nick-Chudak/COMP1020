/**
 * Name of class or program (matches filename)
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 2, question 3
 * @author       Mykola Chudak, 8043157
 * @version      2/20/2025
 */

public class Schedule {
    private Stop[] stops;
    private String destination;

    public Schedule(String line) throws BadScheduleException, IllegalArgumentException {
        if (line == null) {
            throw new IllegalArgumentException("Input line cannot be null");
        }
        
        if (line.isBlank()) {
            throw new IllegalArgumentException("Input line cannot be empty");
        }
        
        String[] listOfStops = line.split(",");
        
        stops = new Stop[listOfStops.length]; // Initialize the stops array
        int index = 0;
        
        for (String stop : listOfStops) {
            int colonIndex = stop.indexOf(":");
            if (colonIndex != -1 && colonIndex < stop.lastIndexOf(":")) {
                String city = stop.substring(0, colonIndex).trim();
                String timePart = stop.substring(colonIndex + 1).trim();
        
                int lastColonIndex = timePart.lastIndexOf(":");
                if (lastColonIndex != -1) {
                    String arrivalTime = timePart.substring(0, lastColonIndex - 3).trim();
                    String departureTime = timePart.substring(lastColonIndex - 2).trim();
        
                    if (!Stop.isValidTime(arrivalTime) || !Stop.isValidTime(departureTime) || Stop.compareTimes(arrivalTime, departureTime) >= 0) {
                        throw new IllegalArgumentException("Invalid time sequence: Arrival time must be before departure time at " + city);
                    }
        
                    stops[index++] = new Stop(city, arrivalTime, departureTime);
                } else {
                    throw new IllegalArgumentException("Invalid time format: Expected format HH:mm-HH:mm");
                }
            } else {
                throw new IllegalArgumentException("Invalid stop format: Expected format 'Station A:HH:mm-HH:mm'");
            }
        }
        
        if (stops.length == 0) {
            throw new IllegalArgumentException("Argument stops must contain at least one stop");
        }
        
        refreshDestination();
        
    }

    public Schedule(Stop[] stops) throws IllegalArgumentException {
        if (stops == null) {
            throw new IllegalArgumentException("Argument stops must contain at least one stop");
        }

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
