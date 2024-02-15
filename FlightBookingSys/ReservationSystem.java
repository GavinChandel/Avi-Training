package FlightBookingSys;

import java.util.HashMap;

// Class extending Flight to handle reservation system
class ReservationSystem extends Flight {
    // Static HashMap to store flight numbers and available seats
    private static HashMap<Integer, Integer> map = new HashMap<>();

    // Constructor
    public ReservationSystem() {
    }

    // Method to add flights to the database
    public static void flightDB(int number, int seats) {
        map.put(number, seats);
    }

    // Method to check available seats for a given flight number
    public int check(int number) {
        return map.get(number);
    }

    // Method to book seats for a given flight number
    public void booking(int number, int seats) throws ReservationException {
        if (map.containsKey(number)) {
            int availableSeats = map.get(number);
            if (availableSeats > 0 && availableSeats > seats) {
                // Reduce available seats and confirm booking
                map.put(number, availableSeats - seats);
                System.out.println("Your Booking is done");
            } else {
                // Throw exception if no seats available
                throw new ReservationException("No seats available");
            }
        } else {
            // Throw exception if flight number not found
            throw new ReservationException("No such flight available");
        }
    }
}
