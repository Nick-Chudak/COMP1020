/**
 * Name of class or program (matches filename)
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 2, question 2
 * @author       Mykola Chudak, 8043157
 * @version      2/20/2025
 */

public class Car {
    private int carNumber;
    private int luggageWeight;
    private boolean[] seatingList;
    private String seatingLayout;
    
    private static final int LUGGAGE_PER_PASSENGER_KG = 25;

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
            return this.seatingList[seatNumber - 1] == false;
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
        return (this.luggageWeight + luggageWeightToAdd) <= Car.getMaxWeight(this.seatingList.length);
    }

    public void addLuggage(int luggageWeightToAdd) {

        if (this.canAddLuggage(luggageWeightToAdd)) {
            this.luggageWeight += luggageWeightToAdd;
        }

        this.luggageWeight = (this.luggageWeight >= 0) ? this.luggageWeight : 0;
    }

    public String toString() {
        String seating = this.seatingLayout;
        int index = 0;
        String result = "";
    
        for (int i = 0; i < seating.length(); i++) {
            char currentChar = seating.charAt(i);
    
            if (currentChar == 'X') {
                result += "XX";
                index++;
            } else if (currentChar == 'O') {
                result += String.format("%02d", (index + 1)); // Replace 'O' with a seat number
                index++;
            } else {
                result += currentChar; // Keep other characters unchanged
            }
        }
    
        return "Car: " + this.carNumber + "\n" + "Luggage Weight: " + this.luggageWeight + "kg" + "\n" + result;
    }

    public static int getMaxWeight(int capacity) {
        return LUGGAGE_PER_PASSENGER_KG * capacity * 2;
    }
}
