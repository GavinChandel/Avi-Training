package FlightBookingSys;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightSystem {
    public static void main(String[] args) {
        try {
            // Creating a Flight object with flight number 01, origin "bombay",
            // destination "delhi", and available seats 10.
            Flight flight1 = new Flight(01, "bombay", "delhi", 10);

            // Creating a new ReservationSystem object.
            ReservationSystem reservationSystem = new ReservationSystem();

            // Adding flight information to the reservation system's flight database.
            ReservationSystem.flightDB(flight1.getFlightNumber(), flight1.getAvailableSeats());

            // Booking 2 seats for flight number 01.
            reservationSystem.booking(01, 2);

            // Checking the availability of seats for flight number 01.
            System.out.println(reservationSystem.check(01));
        } catch (ReservationException e) {
            // Handling any ReservationException that might occur during the execution.
            System.out.println("Error: " + e.getMessage());
        }
    }
}
