// Package declaration for the CarRentalSystem package
package CarRentalSystem;

// Import statements for required Java utilities
import java.util.HashMap;
import java.util.Map;

// Customer class representing a customer of the car rental system
class Customer {
    // Private fields for name, email, and rented vehicles map
    private String name;
    private String email;
    private Map<Integer, Vehicle> rentedVehicles; // Map to store rented vehicles with their IDs

    // Constructor to initialize name, email, and rentedVehicles map
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.rentedVehicles = new HashMap<>(); // Initialize rentedVehicles as an empty HashMap
    }

    // Getter method to retrieve the name of the customer
    public String getName() {
        return name;
    }

    // Getter method to retrieve the map of rented vehicles
    public Map<Integer, Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    // Method to rent a vehicle and associate it with a vehicle ID
    public void rentVehicle(Vehicle vehicle, int vehicleId) {
        rentedVehicles.put(vehicleId, vehicle); // Add the vehicle to the rentedVehicles map with the specified ID
    }

    // Method to return a rented vehicle based on its vehicle ID
    public void returnVehicle(int vehicleId) {
        rentedVehicles.remove(vehicleId); // Remove the vehicle from the rentedVehicles map based on its ID
    }
}
