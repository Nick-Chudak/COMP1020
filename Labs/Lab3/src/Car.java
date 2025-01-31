public class Car{
    private String make;
    private String model;
    private int year;
    private double mileage;

    public Car (String make, String model, int year, double mileage) {
        
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public double getMileage() {
        return this.mileage;
    }

    public String toString() {
        
        return this.getMake() + " " + this.getModel() + " " +
        this.getYear() + " " +  this.getMileage();
    }
}
