// Package declaration for the CarRentalSystem package
package CarRentalSystem;

// Import statements for required Java utilities
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// RentalAgency class representing the car rental agency
class RentalAgency {
    // Private fields for available vehicles list and rented vehicles map
    private List<Vehicle> availableVehicles; // List of available vehicles
    private Map<Customer, Map<Integer, Vehicle>> rentedVehiclesMap; // Map of rented vehicles by customer

    // Constructor to initialize availableVehicles and rentedVehiclesMap
    public RentalAgency() {
        this.availableVehicles = new ArrayList<>(); // Initialize availableVehicles as an empty ArrayList
        this.rentedVehiclesMap = new HashMap<>(); // Initialize rentedVehiclesMap as an empty HashMap
    }

    // Method to add a vehicle to the list of available vehicles
    public void addVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle); // Add the vehicle to the list of available vehicles
    }

    // Method to rent a vehicle to a customer for a specified number of days
    public void rentVehicle(Customer customer, Vehicle vehicle, int days, int vehicleId) {
        // Check if the vehicle is available for rent
        if (!availableVehicles.contains(vehicle)) {
            throw new IllegalArgumentException("Vehicle not available for rent.");
        }
        // Calculate the rental cost for the specified number of days
        double cost = vehicle.calculateRentalCost(days);
        // Print confirmation message
        System.out.println("Vehicle rented to " + customer.getName() + " for Rs." + cost);
        // Rent the vehicle to the customer
        customer.rentVehicle(vehicle, vehicleId);
        // Remove the vehicle from the list of available vehicles
        availableVehicles.remove(vehicle);

        // Update the rented vehicles map
        rentedVehiclesMap.putIfAbsent(customer, new HashMap<>());
        rentedVehiclesMap.get(customer).put(vehicleId, vehicle);
    }

    // Method to return a rented vehicle by a customer
    public void returnVehicle(Customer customer, int vehicleId) {
        // Retrieve the rented vehicles map for the customer
        Map<Integer, Vehicle> customerRentedVehicles = rentedVehiclesMap.get(customer);
        // Check if the customer has rented any vehicles or if the specified vehicle is rented by the customer
        if (customerRentedVehicles == null || !customerRentedVehicles.containsKey(vehicleId)) {
            throw new IllegalArgumentException("Vehicle not rented by this customer.");
        }
        // Return the vehicle by the customer
        customer.returnVehicle(vehicleId);
        // Add the returned vehicle back to the list of available vehicles
        availableVehicles.add(customerRentedVehicles.remove(vehicleId));
        // Print confirmation message
        System.out.println("Vehicle returned successfully by " + customer.getName());

        // If the customer has returned all rented vehicles, remove the customer entry from the rented vehicles map
        if (customerRentedVehicles.isEmpty()) {
            rentedVehiclesMap.remove(customer);
        }
    }

    // Method to get the rented vehicles associated with a customer
    public Map<Integer, Vehicle> getRentedVehiclesByCustomer(Customer customer) {
        return rentedVehiclesMap.getOrDefault(customer, new HashMap<>());
    }

    // Method to get the list of available vehicles
    public List<Vehicle> getAvailableVehicles() {
        return availableVehicles;
    }
}
