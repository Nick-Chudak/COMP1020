import java.util.Random;

public class Lab3Ex2Solution {
  public static void main(String[] args) {
    final int NUM_CARS = 20;
    int NUM_DRIVERS = 4;
    Random rand = new Random();
    
    Car[] cars = new Car[NUM_CARS];
    Driver[] drivers = new Driver[NUM_DRIVERS];

    int carsSize = 11;
    
    // or start out with parallel arrays and make a loop...
    cars[0] = new Car("Ford", "Focus", 2012, 7.2);
    cars[1] = new Car("Toyota", "RAV4", 1998, 9.5);
    cars[2] = new Car("Cadillac", "Escalade", 2000, 23.1);
    cars[3] = new Car("Ford", "Fiesta", 1997, 6.3);
    cars[4] = new Car("VW", "Golf GTI", 2015, 8.4);
    cars[5] = new Car("Ford", "F-150", 2010, 14.0);
    cars[6] = new Car("Toyota", "Corolla", 2005, 8.2);
    cars[7] = new Car("Datsun", "240Z", 1968, 15.6);
    cars[8] = new Car("Hyundai", "Pony", 1995, 10.0);
    cars[9] = new Car("Toyota", "FJ Cruiser", 2012, 13.2);
    cars[10] = new Car("Chevy", "Bolt", 2018, 0.0);

    for (int i = 0; i < 4; i++){
      drivers[i] = new Driver("Driver" + Integer.toString(i), "12/31/2024", (2000 + rand.nextInt(25)), (rand.nextInt(2) != 0));
    }

    System.out.println("Printing all drivers: \n");

    for (int i = 0; i < drivers.length; i++) {
      System.out.println(drivers[i]);
    }

    for (int i = 2; i < cars.length; i++) {
      if (cars[i] != null) {
        cars[i].setDriver(drivers[rand.nextInt(4)]);
      }
    }


    
    System.out.println("Printing all cars after setting driver: \n");
    for (int i = 0; i < carsSize; i++) {
      System.out.println(cars[i]);
    }

  }



  public static void printCars(Car[] cars, int carsSize) {
    for (int i = 0; i < carsSize; i++) {
      Car car = cars[i];
      System.out.println(car);
    }
  }

  public static void printCarsByMake(Car[] cars, int carsSize, String make) {
    for (int i = 0; i < carsSize; i++) {
      Car car = cars[i];
      if (make.equals(car.getMake())) {
        System.out.println(car);
      }
    }
  }

  public static void printCarsInYearRange(Car[] cars, int carsSize, int fromYear, int toYear) {
    for (int i = 0; i < carsSize; i++) {
      Car car = cars[i];
      if (car.getYear() >= fromYear && car.getYear() <= toYear) {
        System.out.println(car);
      }
    }
  }
  
  public static void printCarsWithMileageThreshold(Car[] cars, int carsSize, boolean above, double threshhold) {
    for (int i = 0; i < carsSize; i++) {
      Car car = cars[i];
      if ((above && car.getLPer100Km() >= threshhold) || (!above && car.getLPer100Km() < threshhold)) {
        System.out.println(car);
      }
    }
  }
}

class Car {
  private String make;
  private String model;
  private int year;
  private double lPer100Km;
  private Driver carDriver;

  public Car(String make, String model, int year, double lPer100Km) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.lPer100Km = lPer100Km;
  }

  public void setDriver(Driver driver) {
    this.carDriver = driver;
  }
  
  public String getMake() {
    return make;
  }

  public int getYear() {
    return year;
  }

  public double getLPer100Km() {
    return lPer100Km;
  }
  
  public String toString() {

    if (this.carDriver == null) {
      return String.format("%s %s (%d) %.1fl/100km %s", make, model, year, lPer100Km, "No driver");
    } else {
      return String.format("%s %s (%d) %.1fl/100km %s", make, model, year, lPer100Km, this.carDriver.getDriverName());
    }
  }
}

class Driver {
  private String name;
  private String date;
  private int expiryYear;
  private boolean requireGlasses;

  public Driver(String name, String date, int expiryYear, boolean requireGlasses) {
    this.name = name;
    this.date = date;
    this.expiryYear = expiryYear;
    this.requireGlasses = requireGlasses;
  }

  public String toString() {
    return String.format("%s %s %d %b", this.name, this.date, this.expiryYear, this.requireGlasses);
  }

  public void updateExpiryYear(int years) {

    if (years < 0) {
      System.out.println("Cannot decrease the expiryDate");

    } else {
      this.expiryYear += years;
    }
  }

  public String getDriverName() {
    return this.name;
  }
}