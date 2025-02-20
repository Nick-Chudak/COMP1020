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

            
        String carDescription = """
            Car: 1
            | O O O |
            | O X O |
            | O O O |
            Luggage Weight: 50kg
            """;
            try {
            // Create a Car object
            Car car = new Car(carDescription);
            // Initial car details
            System.out.println(car);
            /*
            Expected Output:
            Car: 1
            Luggage Weight: 50kg
            | 01 02 03 |
            | 04 XX 06 |
            | 07 08 09 |
            */
            // Reserve a seat (seat 3) with luggage weight 20kg
            System.out.println(car.reserveSeat(3, 20));
            /*
            Expected Output:
            0
            */
            // Car details after reserving seat 3
            System.out.println(car);
            /*
            Expected Output:
            Car: 1
            Luggage Weight: 70kg
            | 01 02 XX |
            | 04 XX 06 |
            | 07 08 09 |
            */
            // Attempt to reserve an already occupied seat (seat 5)
            System.out.println(car.reserveSeat(5, 15));
            // Expected Output:1
            // Car details after attempting to reserve seat 5
            System.out.println(car);
            /*
            Expected Output:
            Car: 1
            Luggage Weight: 70kg
            | 01 02 XX |
            | 04 XX 06 |
            | 07 08 09 |
            */
            // Cancel the reservation for seat 3
            car.cancelReservation(3);
            System.out.println(car);
            /*
            Expected Output:
            Car: 1
            Luggage Weight: 70kg
            | 01 02 03 |
            | 04 XX 06 |
            | 07 08 09 |
            */
            } catch (IllegalArgumentException e) {
            System.err.println("Error initializing the car: " + e.getMessage());
            } catch (BadTrainException e) {
            System.err.println("Error handling the car operations: " + e.getMessage());
            }
        }
    }
}
