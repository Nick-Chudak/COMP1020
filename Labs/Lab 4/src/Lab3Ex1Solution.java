// public class Lab3Ex1Solution {
//   public static void main(String[] args) {
//     final int NUM_CARS = 10;
    
//     Car[] cars = new Car[NUM_CARS];
    
//     // or start out with parallel arrays and make a loop...
//     cars[0] = new Car("Ford", "Focus", 2012, 7.2);
//     cars[1] = new Car("Toyota", "RAV4", 1998, 9.5);
//     cars[2] = new Car("Cadillac", "Escalade", 2000, 23.1);
//     cars[3] = new Car("Ford", "Fiesta", 1997, 6.3);
//     cars[4] = new Car("VW", "Golf GTI", 2015, 8.4);
//     cars[5] = new Car("Ford", "F-150", 2010, 14.0);
//     cars[6] = new Car("Toyota", "Corolla", 2005, 8.2);
//     cars[7] = new Car("Datsun", "240Z", 1968, 15.6);
//     cars[8] = new Car("Hyundai", "Pony", 1995, 10.0);
//     cars[9] = new Car("Toyota", "FJ Cruiser", 2012, 13.2);
		
//     System.out.println("All the cars:");
//     printCars(cars);

//     System.out.println("\nFords:");
//     printCarsByMake(cars, "Ford");
//     System.out.println("\nToyotas:");
//     printCarsByMake(cars, "Toyota");
//     System.out.println("\nLadas:");
//     printCarsByMake(cars, "Lada");

//     System.out.println("\nCars made in 2000-2010:");
//     printCarsInYearRange(cars, 2000, 2010);
//     System.out.println("\nCars made in the 1990s:");
//     printCarsInYearRange(cars, 1900, 1999);
//     System.out.println("\nCars made in 2012:");
//     printCarsInYearRange(cars, 2012, 2012);
//     System.out.println("\nCars made in 2013:");
//     printCarsInYearRange(cars, 2013, 2013);
    
//     System.out.println("\nBetter than 10 l/100km:");
//     printCarsWithMileageThreshold(cars, false, 10.0);
//     System.out.println("\nWorse than 10 l/100km:");
//     printCarsWithMileageThreshold(cars, true, 10.0);
    
//     System.out.println("\n*** End of program. ***");
//   }
  
//   public static void printCars(Car[] cars) {
//     for (Car car: cars) {
//       System.out.println(car);
//     }
//   }

//   public static void printCarsByMake(Car[] cars, String make) {
//     for (Car car: cars) {
//       if (make.equals(car.getMake())) {
//         System.out.println(car);
//       }
//     }
//   }

//   public static void printCarsInYearRange(Car[] cars, int fromYear, int toYear) {
//     for (Car car: cars) {
//       if (car.getYear() >= fromYear && car.getYear() <= toYear) {
//         System.out.println(car);
//       }
//     }
//   }
  
//   // Alternative: printCarsInMileageRange(Car[] cars, int fromMileage, int toMileage)
//   public static void printCarsWithMileageThreshold(Car[] cars, boolean above, double threshhold) {
//     for (Car car: cars) {
//       if ((above && car.getLPer100Km() >= threshhold) || (!above && car.getLPer100Km() < threshhold)) {
//         System.out.println(car);
//       }
//     }
//   }
// }

// class Car {
//   private String make;
//   private String model;
//   private int year;
//   private double lPer100Km;
  
//   public Car(String make, String model, int year, double lPer100Km) {
//     this.make = make;
//     this.model = model;
//     this.year = year;
//     this.lPer100Km = lPer100Km;
//   }
  
//   public String getMake() {
//     return make;
//   }

//   public int getYear() {
//     return year;
//   }

//   public double getLPer100Km() {
//     return lPer100Km;
//   }
  
//   public String toString() {
//     return String.format("%s %s (%d) %.1fl/100km", make, model, year, lPer100Km);
//   }
// }
