// Package declaration for the CarRentalSystem package
package CarRentalSystem;

// Import statements for required Java utilities
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Main class representing the main entry point of the car rental system
public class Main {
    public static void main(String[] args) {
        // Create a new instance of RentalAgency to manage vehicle rentals
        RentalAgency rentalAgency = new RentalAgency();
        // Create a new instance of Scanner to read user input
        Scanner scanner = new Scanner(System.in);
        // List to store customers
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;

        // Main menu loop
        while (true) {
            // Displaying the car rental system menu
            System.out.println("Car Rental System Menu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Add a customer");
            System.out.println("3. Rent a vehicle");
            System.out.println("4. Return a vehicle");
            System.out.println("5. View vehicles in the store");
            System.out.println("6. Display rented vehicles of the current customer");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // Reading the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Switch case to handle user's choice
            switch (choice) {
                case 1:
                    // Adding a new vehicle
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter rental price per day: ");
                    double rentalPrice = scanner.nextDouble();
                    System.out.print("Enter number of seats: ");
                    int numSeats = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter fuel type: ");
                    String fuelType = scanner.nextLine();

                    // Create a new Car instance and add it to the rental agency
                    rentalAgency.addVehicle(new Car(make, model, year, rentalPrice, numSeats, fuelType));
                    System.out.println("Vehicle added successfully.");
                    break;

                case 2:
                    // Adding a new customer
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String customerEmail = scanner.nextLine();

                    // Create a new Customer instance and add it to the list of customers
                    customer = new Customer(customerName, customerEmail);
                    customers.add(customer);
                    System.out.println("Customer added successfully.");
                    break;

                case 3:
                    // Renting a vehicle
                    System.out.print("Enter customer name: ");
                    String customerNameRent = scanner.nextLine();
                    Customer rentingCustomer = null;

                    // Finding the customer by name from the list of customers
                    for (Customer existingCustomer : customers) {
                        if (existingCustomer.getName().equalsIgnoreCase(customerNameRent)) {
                            rentingCustomer = existingCustomer;
                            break;
                        }
                    }

                    // Checking if the customer exists
                    if (rentingCustomer == null) {
                        System.out.println("Customer not found. Please add the customer first.");
                        break;
                    }

                    // Getting the list of available vehicles
                    List<Vehicle> availableVehicles = rentalAgency.getAvailableVehicles();
                    // Checking if there are available vehicles
                    if (availableVehicles.isEmpty()) {
                        System.out.println("No vehicles available for rent.");
                        break;
                    }

                    // Displaying available vehicles
                    System.out.println("Available vehicles:");
                    for (int i = 0; i < availableVehicles.size(); i++) {
                        Vehicle vehicle = availableVehicles.get(i);
                        System.out.println(i + ". " + vehicle.getMake() + " " + vehicle.getModel());
                    }
                    System.out.print("Enter vehicle index to rent: ");
                    int vehicleIndex = scanner.nextInt();
                    System.out.print("Enter rental duration (days): ");
                    int rentalDays = scanner.nextInt();
                    System.out.print("Enter vehicle ID: ");
                    int vehicleId = scanner.nextInt();

                    // Renting the selected vehicle to the customer
                    rentalAgency.rentVehicle(rentingCustomer, availableVehicles.get(vehicleIndex), rentalDays, vehicleId);
                    break;

                case 4:
                    // Returning a vehicle
                    if (customer == null) {
                        System.out.println("Please add a customer first.");
                        break;
                    }
                    // Getting the rented vehicles by the current customer
                    Map<Integer, Vehicle> rentedVehicles = rentalAgency.getRentedVehiclesByCustomer(customer);
                    if (rentedVehicles.isEmpty()) {
                        System.out.println("No vehicles rented by this customer.");
                        break;
                    }
                    // Displaying rented vehicles by the current customer
                    System.out.println("Rented vehicles:");
                    for (Map.Entry<Integer, Vehicle> entry : rentedVehicles.entrySet()) {
                        System.out.println(entry.getKey() + ". " + entry.getValue().getMake() + " " + entry.getValue().getModel());
                    }
                    System.out.print("Enter vehicle ID to return: ");
                    int returnVehicleId = scanner.nextInt();
                    // Returning the selected vehicle by the current customer
                    rentalAgency.returnVehicle(customer, returnVehicleId);
                    break;

                case 5:
                    // Viewing available vehicles in the store
                    List<Vehicle> vehicles = rentalAgency.getAvailableVehicles();
                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles available yet!!");
                        break;
                    }
                    // Displaying available vehicles
                    System.out.println("Available vehicles:");
                    for (int i = 0; i < vehicles.size(); i++) {
                        Vehicle vehicle = vehicles.get(i);
                        System.out.println(i + ". " + vehicle.getMake() + " " + vehicle.getModel());
                    }
                    break;

                case 6:
                    // Displaying rented vehicles of the current customer
                    if (customer == null) {
                        System.out.println("Please add a customer first.");
                        break;
                    }
                    Map<Integer, Vehicle> rentedVehiclesByCustomer = rentalAgency.getRentedVehiclesByCustomer(customer);
                    if (rentedVehiclesByCustomer.isEmpty()) {
                        System.out.println("No vehicles rented by this customer.");
                    } else {
                        System.out.println("Rented vehicles by " + customer.getName() + ":");
                        for (Map.Entry<Integer, Vehicle> entry : rentedVehiclesByCustomer.entrySet()) {
                            System.out.println(entry.getKey() + ". " + entry.getValue().getMake() + " " + entry.getValue().getModel());
                        }
                    }
                    break;

                case 7:
                    // Exiting the program
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    // Handling invalid choice
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
