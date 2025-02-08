public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Creating a valid Stop object
            Stop stop1 = new Stop("Central Station", "10:30", "11:00");
            System.out.println(stop1);
            // Expected output: Stop Name: Central Station, Arrival: 10:30, Departure:
            // Accessing and displaying station name
            System.out.println("Station Name: " + stop1.getStationName());
            // Expected output: Station Name: Central Station
            // Accessing and displaying arrival time
            System.out.println("Arrival Time: " + stop1.getArrivalTime());
            // Expected output: Arrival Time: 10:30
            // Accessing and displaying departure time
            System.out.println("Departure Time: " + stop1.getDepartureTime());
            // Expected output: Departure Time: 11:00
            // Comparing two times
            int comparisonResult = Stop.compareTimes("10:30", "11:00");
            System.out.println("Comparing 10:30 and 11:00: " + comparisonResult);
            // Expected output: Comparing 10:30 and 11:00: -1 (indicating 10:30 < 11:00)
            // Check a valid time
            boolean validTime = Stop.isValidTime("23:59");
            System.out.println("Checking if 23:59 is a valid time: " + validTime);
            // Expected output: Checking if 23:59 is a valid time: true
            // Check an invalid time
            boolean inValidTime = Stop.isValidTime("-15:59.4");
            System.out.println("Checking if -15:59.4 is a valid time: " + inValidTime);
            // Expected ooutput: Checking if -15:59.4 is a valid time: false
            } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
            } catch (BadScheduleException e) {
            System.out.println("BadScheduleException: " + e.getMessage());
        }
    }
}
