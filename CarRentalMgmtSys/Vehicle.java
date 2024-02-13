// Package declaration for the CarRentalSystem package
package CarRentalSystem;

// Abstract class representing a Vehicle
abstract class Vehicle {
    // Private fields for make, model, year, and rental price of the vehicle
    private String make;
    private String model;
    private int year;
    protected double rentalPrice; // Protected field to be accessible in subclasses

    // Constructor to initialize make, model, year, and rentalPrice of the vehicle
    public Vehicle(String make, String model, int year, double rentalPrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    // Abstract method to calculate the rental cost for a certain number of days
    public abstract double calculateRentalCost(int days);

    // Getter method to retrieve the make of the vehicle
    public String getMake() {
        return make;
    }

    // Getter method to retrieve the model of the vehicle
    public String getModel() {
        return model;
    }

    // Getter method to retrieve the year of the vehicle
    public int getYear() {
        return year;
    }
}
