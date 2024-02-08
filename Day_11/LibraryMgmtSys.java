package javaBasics.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class Item
abstract class Item {
    // Private fields of Item class
    private String id;
    private String title;
    private String author;
    private boolean checkedOut;
    private int quantity; // Add quantity field

    // Constructor for Item class
    public Item(String id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity; // Set quantity
        this.checkedOut = false; // Initially, item is not checked out
    }

    // Getter methods for private fields
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    // Method to check out the item
    public void checkOut() {
        if (quantity > 0) { // If item is available
            quantity--; // Decrease quantity
            checkedOut = true; // Mark item as checked out
            System.out.println('"'+title+'"'+ " has been checked out."); // Print message
        } else {
            System.out.println("Sorry, " +'"' +title +'"'+ " is out of stock."); // Print message if item is out of stock
        }
    }

    // Method to return the item
    public void returnItem() {
        if (checkedOut) { // If item is checked out
            quantity++; // Increase quantity
            checkedOut = false; // Mark item as returned
            System.out.println(title + " has been returned."); // Print message
        } else {
            System.out.println(title + " is already in the library."); // Print message if item is already in library
        }
    }

    // Abstract method to display item details
    public abstract void displayDetails();
}

// Book class inheriting from Item
class Book extends Item {
    // Private field of Book class
    private String ISBN;

    // Constructor for Book class
    public Book(String id, String title, String author, String ISBN, int quantity) {
        super(id, title, author, quantity); // Call superclass constructor
        this.ISBN = ISBN; // Initialize ISBN
    }

    // Override displayDetails method
    @Override
    public void displayDetails() {
        // Display details of the book
        System.out.println("ID- " + getId()+", Title- " + getTitle()+", Author- " + getAuthor()+", ISBN- " + ISBN+", Quantity- " + getQuantity());
    }
}

// LibraryMember class
class LibraryMember {
    // Private fields of LibraryMember class
    private String memberId;
    private String name;

    // Constructor for LibraryMember class
    public LibraryMember(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Getter methods for private fields
    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    // Method to check out an item
    public void checkOutItem(Item item) {
        System.out.println(name + " checked out the item: " + item.getTitle());
    }

    // Method to return an item
    public void returnItem(Item item) {
        System.out.println(name + " returned the item: " + item.getTitle());
    }
}

// Library class
class Library {
    // Private fields of Library class
    private List<Item> inventory;
    private List<LibraryMember> members;

    // Constructor for Library class
    public Library() {
        inventory = new ArrayList<>(); // Initialize inventory as an ArrayList
        members = new ArrayList<>(); // Initialize members as an ArrayList
    }

    // Method to add items to inventory
    public void addItem(Item item) {
        inventory.add(item); // Add item to inventory
    }

    // Method to register members
    public void registerMember(LibraryMember member) {
        members.add(member); // Add member to list of members
    }

    // Method to display item details
    public void displayItemDetails() {
        for (Item item : inventory) {
            item.displayDetails(); // Display details of each item in inventory
        }
    }

    // Getter methods for private fields
    public List<Item> getInventory() {
        return inventory;
    }

    public List<LibraryMember> getMembers(){
        return members;
    }
}

// Main class LibraryMgmtSys
public class LibraryMgmtSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        Library library = new Library(); // Create a Library object

        while (true) {
            // Display menu options
            System.out.println("\n1. Add item to library");
            System.out.println("2. Register a member");
            System.out.println("3. Display members");
            System.out.println("4. Check out an item");
            System.out.println("5. Return an item");
            System.out.println("6. Display item details");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt(); // Read user input for menu option
            scanner.nextLine(); // Consume newline character

            try {
                switch (option) {
                    case 1:
                        // Add a book to the library
                        System.out.println("Enter details of the book:");
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("ISBN: ");
                        String ISBN = scanner.nextLine();
                        System.out.print("Quantity: ");
                        int quantity= scanner.nextInt();
                        Book book = new Book(id, title, author, ISBN,quantity); // Create a new Book object
                        library.addItem(book); // Add the book to the library
                        System.out.println("Item added successfully!!!");
                        break;
                    case 2:
                        // Register a library member
                        System.out.println("Enter details of the library member:");
                        System.out.print("Member ID: ");
                        String memberId = scanner.nextLine();
                        System.out.print("Member Name: ");
                        String name = scanner.nextLine();
                        LibraryMember member = new LibraryMember(memberId, name); // Create a new LibraryMember object
                        library.registerMember(member); // Register the member
                        System.out.println("Member added successfully!!!");
                        break;
                    case 3:
                        // Display all library members
                        System.out.println("Members:");
                        for (LibraryMember member1:library.getMembers()) {
                            String id1 = member1.getMemberId();
                            String s = member1.getName();
                            System.out.println(id1+" "+s);
                        }
                        break;
                    case 4:
                        // Check out an item
                        System.out.println("Enter the ID of the item to be checked out:");
                        String checkoutId = scanner.nextLine();
                        for (Item item : library.getInventory()) {
                            if (item.getId().equals(checkoutId)) {
                                item.checkOut();
                                break;
                            }
                        }
                        break;
                    case 5:
                        // Return an item
                        System.out.println("Enter the ID of the item to be returned:");
                        String returnId = scanner.nextLine();
                        for (Item item : library.getInventory()) {
                            if (item.getId().equals(returnId)) {
                                item.returnItem();
                                System.out.println("Item returned successfully!!!");
                                break;
                            }
                        }
                        break;
                    case 6:
                        // Display details of all items in the library
                        System.out.println("Item Details:");
                        library.displayItemDetails();
                        break;
                    case 7:
                        // Exit the program
                        System.out.println("Exiting...");
                        scanner.close(); // Close the scanner
                        System.exit(0); // Exit the program
                    default:
                        // Handle invalid option
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                // Catch any exceptions and display error message
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Consume newline character
            }
        }
    }
}
