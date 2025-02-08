public class Car {
    private int carNumber;
    private int luggageWeight;
    private boolean[] seatingList;
    private String seatingLayout;
    
    private static final int LUGGAGE_PER_PASSENGER_KG = 25;

    public Car(String carDescription) throws IllegalArgumentException {
    
    }

    public Car(int carNumber, int luggageWeight, boolean[] seatingList, String seatingLayout) {

    }

    public int getCarNumber() {
        return this.carNumber;
    }


    public boolean isSeatAvailable(int seatNumber) {

    }
}
