// Define a package named FlightBookingSys
package FlightBookingSys;

// Define a custom exception class named ReservationException that extends the built-in Exception class
class ReservationException extends Exception {
    // Constructor for ReservationException class that takes a String parameter 'exc'
    public ReservationException(String e) {
        // Call the constructor of the superclass (Exception) and pass the 'exc' parameter to it
        super(e);
    }
}
