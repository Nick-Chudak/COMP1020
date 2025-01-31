public class App {
    public static void main(String[] args) throws Exception {

        Car myCar = new Car("Ford", "F150", 2010, 24.5);
        System.out.println(myCar);

        //#1
        ListCars cars = new ListCars();

        //2
        System.out.println("Printing all cars: ");
        cars.printAllCars();
        System.out.println("");

        //3
        System.out.println("Printing cars by make: ");
        cars.printCarByMake("Ford");
        System.out.println("");
        
        //4
        System.out.println("Printing cars by year: ");
        cars.printWithinRange(2000, 2020);
        System.out.println("");
        
        //5
        System.out.println("Printing eirther or: ");
        System.out.println("Either: ");
        cars.printEitherOr("either");

        System.out.println("");
        System.out.println("Or: ");
        cars.printEitherOr("or");

    }
}
