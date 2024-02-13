// Package declaration for the CarRentalSystem package
package CarRentalSystem;

// Car class extending the abstract class Vehicle
class Car extends Vehicle {
    // Private fields specific to Car class for number of seats and fuel type
    private int numSeats;
    private String fuelType;

    // Constructor to initialize Car object with make, model, year, rentalPrice, numSeats, and fuelType
    public Car(String make, String model, int year, double rentalPrice, int numSeats, String fuelType) {
        // Call to superclass constructor to initialize inherited fields
        super(make, model, year, rentalPrice);
        // Initialize Car-specific fields
        this.numSeats = numSeats;
        this.fuelType = fuelType;
    }

    // Override method to calculate rental cost for a certain number of days
    @Override
    public double calculateRentalCost(int days) {
        // Calculate rental cost based on the rental price per day and number of days
        return rentalPrice * days;
    }
}
