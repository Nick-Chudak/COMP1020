import java.util.Random;

public class ListCars{
    private String[] CAR_MAKES = {"Chevy", "Ford", "Toyota", "Honda"};

    private Car[] listCars;

    // public ListCars (String make, String model, int year, double mileage) {
    //     listCars = new Car[10];
    //     Random rand = new Random();

    //     for (int i = 0; i < listCars.length; i++) {
    //         listCars[i] = new Car(make, "Random", 1950 + rand.nextInt(70), (100 + rand.nextInt(50)) / 10);
    //     }
    // }

    public ListCars () {
        listCars = new Car[10];
        Random rand = new Random();

        for (int i = 0; i < listCars.length; i++) {
            listCars[i] = new Car(CAR_MAKES[rand.nextInt(4)], "Random", 1950 + rand.nextInt(70), (80 + rand.nextInt(50)) / 10);
        }
    }

    public void printCarByMake(String make) {

        for (int i = 0; i < listCars.length; i++) {
            
            if (make.equals(listCars[i].getMake())) {
                System.out.println(listCars[i]);
            }
        }
    }

    public void printAllCars() {

        for (int i = 0; i < listCars.length; i++) {
                System.out.println(listCars[i]);
            }
        }

    public void printWithinRange(int lower, int upper) {
        for (int i = 0; i < listCars.length; i++) {
            
            if (lower <= listCars[i].getYear() && listCars[i].getYear() <= upper) {
                System.out.println(listCars[i]);
            }
        }
    }

    public void printEitherOr(int mileage) {

        if (condition.equals("either")) {
            for (int i = 0; i < listCars.length; i++) {

                if (listCars[i].getMileage() >= mileage)
                    System.out.println(listCars[i]);
                }
        } else {
            for (int i = 0; i < listCars.length; i++) {

                if (listCars[i].getMileage() < mileage)
                    System.out.println(listCars[i]);
                }
            }
        }
    }
