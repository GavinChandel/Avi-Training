package FlightBookingSys;

import java.util.ArrayList;

// Define a class named Flight
class Flight {
    // Create an ArrayList to store flights
    ArrayList<Flight> flights = new ArrayList<>();

    // Declare private variables to store flight information
    private int flightNumber; // Flight number
    private String departureCity; // Departure city
    private String destinationCity; // Destination city
    private int availableSeats; // Number of available seats

    // Default constructor
    public Flight() {
    }

    // Constructor with parameters to initialize the flight details
    public Flight(int flightNumber, String departureCity, String destinationCity, int availableSeats) throws ReservationException {
        // Initialize the instance variables
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.availableSeats = availableSeats;

        // Check if availableSeats is negative, throw an exception if so
        if (availableSeats < 0) {
            throw new ReservationException("Seats can't be zero");
        }
    }

    // Method to add a flight to the flights ArrayList
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    // Getter method to retrieve the number of available seats
    public int getAvailableSeats() {
        return availableSeats;
    }

    // Getter method to retrieve the flight number
    public int getFlightNumber() {
        return flightNumber;
    }

    // Getter method to retrieve the departure city
    public String getDepartureCity() {
        return departureCity;
    }

    // Getter method to retrieve the destination city
    public String getDestinationCity() {
        return destinationCity;
    }
}
