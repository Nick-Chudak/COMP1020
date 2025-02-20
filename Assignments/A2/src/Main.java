import java.io.*;

public class Main {
    public static void main(String[] args) throws BadScheduleException {
        // Expected input: A string representation of the car
        throw new BadScheduleException("Invalid time format: Times must be in HH:mm format");

//         String carDescription = """
//             Car: 1
//             | O O O |
//             | O X O |
//             | O O O |
//             Luggage Weight: 50kg
//             """;
//         try {
//         // Create a Car object
//             Car car = new Car(carDescription);
//             // Initial car details
//             System.out.println(car);
//             /*
//             Expected Output:
//             Car: 1
//             Luggage Weight: 50kg
//             | 01 02 03 |
//             | 04 XX 06 |
//             | 07 08 09 |
//             */
//             // Reserve a seat (seat 3) with luggage weight 20kg
//             System.out.println(car.reserveSeat(3, 20));
//             /*
//             Expected Output:
//             0
//             */
//             // Car details after reserving seat 3
//             System.out.println(car);
//             /*
//             Expected Output:
//             Car: 1
//             Luggage Weight: 70kg
//             | 01 02 XX |
//             | 04 XX 06 |
//             | 07 08 09 |
//             */
//             // Attempt to reserve an already occupied seat (seat 5)
//             System.out.println(car.reserveSeat(5, 15));
//             // Expected Output:1
//             // Car details after attempting to reserve seat 5
//             System.out.println(car);
//             /*
//             Expected Output:
//             Car: 1
//             Luggage Weight: 70kg
//             | 01 02 XX |
//             | 04 XX 06 |
//             | 07 08 09 |
//             */
//             // Cancel the reservation for seat 3
//             car.cancelReservation(3);
//             System.out.println(car);
//             /*
//             Expected Output:
//             Car: 1
//             Luggage Weight: 70kg
//             | 01 02 03 |
//             | 04 XX 06 |
//             | 07 08 09 |
//             */
//         } catch (IllegalArgumentException e) {
//             System.err.println("Error initializing the car: " + e.getMessage());
//         } catch (BadTrainException e) {
//             System.err.println("Error handling the car operations: " + e.getMessage());
//         }
//     }
// }
