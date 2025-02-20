public class Car {
    private int carNumber;
    private int luggageWeight;
    private boolean[] seatingList;
    private String seatingLayout;
    
    private static final int LUGGAGE_PER_PASSENGER_KG = 25;


    public static void main(String[] args) throws BadTrainException{
        // Expected input: A string representation of the car
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
        } catch (IllegalArgumentException e) {
        System.err.println("Error initializing the car: " + e.getMessage());
        } catch (BadTrainException e) {
        System.err.println("Error handling the car operations: " + e.getMessage());
        }
    }

    public Car(String carDescription) throws IllegalArgumentException {
        String[] lines = carDescription.split("\n");
        String seatingLayout = "";
        int seatingListSize = 0;
        
        if (lines[0].startsWith("Car: ")) {
                try {
                    carNumber = Integer.parseInt(lines[0].split(":")[1].trim());
                    
                    if (carNumber <= 0) {
                        throw new IllegalArgumentException("Invalid format: Car number must be an integer > 0");
                    }

                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid format: Car number must be an integer > 0");
                }
        } else {
            throw new IllegalArgumentException("Invalid format: Car must start with 'Car: '");
        }

        if (lines[lines.length - 1].startsWith("Luggage Weight: ")) {
            try {
                luggageWeight = Integer.parseInt(lines[lines.length - 1].split(":")[1].replaceAll("kg", "").trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid format: Luggage weight must be an integer");
            }
        } else {
            throw new IllegalArgumentException("Invalid format: Luggage weight must start with 'Luggage Weight: '");
        }

        // Extracting seating layout
        for (int i = 1; i < (lines.length - 1); i++) {
            String processedLine = lines[i].replaceAll("[|\\s]", "");
            seatingListSize += processedLine.length();

            if (!(lines[i].startsWith("|") && lines[i].endsWith("|"))) {
                throw new IllegalArgumentException("Invalid format: Each seating line must start and end with '|'");
            }

            if (!(lines[i].matches("[XO \\n\\|]*"))) {
                throw new IllegalArgumentException("Invalid format: Each seat must be either 'X' (occupied), 'O'\r\n" + //
                                        "(available), or empty space");
            }
            
            if (i != (lines.length - 2)) {
                seatingLayout += lines[i] + "\n";
            } else {
                seatingLayout += lines[i];
            }
        } 
        
        seatingList = new boolean[seatingListSize];
        int index = 0;
        for (int i = 1; i < (lines.length - 1); i++) {
            String processedLine = lines[i].replaceAll("[ |]*", "");

            for (int j = 0; j < processedLine.length(); j++) {
                seatingList[index] = (processedLine.charAt(j) == 'X');
                index++;
            }
        }

        this.carNumber = carNumber;
        this.luggageWeight = (luggageWeight > 0) ? luggageWeight : 0;
        this.seatingLayout = seatingLayout;
        this.seatingList = seatingList;
    }

    public Car(int carNumber, int luggageWeight, boolean[] seatingList, String seatingLayout) {
        // Validation for seatingLayout
        String[] lines = seatingLayout.split("\n");
        int seatingListSize = 0;

        for (int i = 0; i < (lines.length); i++) {
            String processedLine = lines[i].replaceAll("[ |]*", "");
            seatingListSize += processedLine.length();

            if (!(lines[i].startsWith("|") && lines[i].endsWith("|"))) {
                throw new IllegalArgumentException("Invalid format: Each seating line must start and end with '|'");
            }

            if (!(lines[i].matches("[XO \\n\\|]*"))) {
                throw new IllegalArgumentException("Invalid format: Each seat must be either 'X' (occupied), 'O'\r\n" + //
                                        "(available), or empty space");
            }
        }

        if (seatingList.length != seatingListSize) {
            throw new IllegalArgumentException("Invalid seating list: Wrong number of elements for seatingList");
        }

        this.carNumber = carNumber;
        this.luggageWeight = (luggageWeight > 0) ? luggageWeight : 0;
        this.seatingLayout = seatingLayout;
        this.seatingList = seatingList;
    }

    public int getCarNumber() {
        return this.carNumber;
    }


    public boolean isSeatAvailable(int seatNumber) throws BadTrainException {

        if (seatNumber >= 1 && seatNumber <= seatingList.length) {
            return this.seatingList[seatNumber - 1] == true;
        } else {
            throw new BadTrainException("Invalid seat number: must be between 1 and\r\n" + //
                                seatingList.length);
        }
    }

    public int reserveSeat(int seatNumber, int luggageWeight) throws BadTrainException {

        if (seatNumber < 1 || seatNumber > seatingList.length) {
            throw new BadTrainException("Invalid seat number: must be between 1 and " + seatingList.length);
        }

        if (seatingList[seatNumber - 1]) {
            return 1;
        }

        seatingList[seatNumber - 1] = true;
        if (luggageWeight < 0) luggageWeight = 0;

        if (canAddLuggage(luggageWeight)) {
            addLuggage(luggageWeight);
            return 0;
        } else {
            return 2;
        }
    }

    public void cancelReservation(int seatNumber) throws BadTrainException {

        // The method is utilized to perform the index validation and avoid out of bound error
        if (this.isSeatAvailable(seatNumber)) {
            this.seatingList[seatNumber - 1] = false;
        } else {
            this.seatingList[seatNumber - 1] = false;
        }
    }

    public boolean canAddLuggage(int luggageWeightToAdd) {
        return (this.luggageWeight + luggageWeightToAdd) <= this.getMaxWeight(this.seatingList.length);
    }

    public void addLuggage(int luggageWeightToAdd) {

        if (this.canAddLuggage(luggageWeightToAdd)) {
            this.luggageWeight += luggageWeightToAdd;
        }

        this.luggageWeight = (this.luggageWeight >= 0) ? this.luggageWeight : 0;
    }

    public String toString() {
        String seating = this.seatingLayout; // Create a copy to avoid modifying the original directly
        int index = 0;
        String result = ""; // New string to store updated layout
    
        for (int i = 0; i < seating.length(); i++) {
            char currentChar = seating.charAt(i);
    
            if (currentChar == 'X') {
                result += "XX"; // Replace 'X' with "XX"
                index++;
            } else if (currentChar == 'O') {
                result += String.format("%02d", (index + 1)); // Replace 'O' with a seat number
                index++;
            } else {
                result += currentChar; // Keep other characters unchanged
            }
        }
    
        return "Car: " + this.carNumber + "\n" + "Luggage Weight: " + this.luggageWeight + "\n" + result;
    }

    public static int getMaxWeight(int capacity) {
        return LUGGAGE_PER_PASSENGER_KG * capacity * 2;
    }
}
