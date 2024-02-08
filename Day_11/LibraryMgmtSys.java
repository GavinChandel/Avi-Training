package javaBasics.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class Item representing items in a library
abstract class Item {
    // Fields common to all items
    private String id;
    private String title;
    private String author;
    private boolean checkedOut;
    private int quantity; // Quantity of the item in stock

    // Constructor to initialize common fields
    public Item(String id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity; // Initialize quantity
        this.checkedOut = false; // Initially not checked out
    }

    // Getters for common fields
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
        if (quantity > 0) {
            quantity--; // Decrease quantity when checked out
            checkedOut = true;
            System.out.println(title + " has been checked out.");
        } else {
            System.out.println("Sorry, " + title + " is out of stock.");
        }
    }

    // Method to return the item
    public void returnItem() {
        if (checkedOut) {
            quantity++; // Increase quantity when returned
            checkedOut = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " is already in the library.");
        }
    }

    // Abstract method to display item details, to be implemented by subclasses
    public abstract void displayDetails();
}

// Book class inheriting from Item
class Book extends Item {
    private String ISBN; // Additional field for books

    // Constructor calling superclass constructor and initializing ISBN
    public Book(String id, String title, String author, String ISBN, int quantity) {
        super(id, title, author, quantity);
        this.ISBN = ISBN;
    }

    // Override displayDetails method to display book details
    @Override
    public void displayDetails() {
        System.out.println("Book Details: ID: " + getId() + ", Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + ISBN + ", Quantity: " + getQuantity());
    }

}

// Magazine class inheriting from Item
class Magazine extends Item {
    private String issueNumber; // Additional field for magazines

    // Constructor calling superclass constructor and initializing issueNumber
    public Magazine(String id, String title, String author, String issueNumber, int quantity) {
        super(id, title, author, quantity);
        this.issueNumber = issueNumber;
    }

    // Override displayDetails method to display magazine details
    @Override
    public void displayDetails() {
        System.out.println("Magazine Details: ID: " + getId() + ", Title: " + getTitle() + ", Author: " + getAuthor() + ", Issue Number: " + issueNumber + ", Quantity: " + getQuantity());
    }

}

// LibraryMember class representing members of the library
class LibraryMember {
    private String memberId;
    private String name;

    // Constructor to initialize member ID and name
    public LibraryMember(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Getters for member ID and name
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

// Library class representing a library with inventory and members
class Library {
    private List<Item> inventory; // List to store library items
    private List<LibraryMember> members; // List to store library members

    // Constructor to initialize inventory and members lists
    public Library() {
        inventory = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Method to add items to inventory
    public void addItem(Item item) {
        inventory.add(item);
    }

    // Method to register members
    public void registerMember(LibraryMember member) {
        members.add(member);
    }

    // Method to display details of all items in inventory
    public void displayItemDetails() {
        for (Item item : inventory) {
            item.displayDetails();
        }
    }

    // Getter for inventory
    public List<Item> getInventory() {
        return inventory;
    }

    // Getter for members
    public List<LibraryMember> getMembers() {
        return members;
    }
}

// Main class
public class LibraryMgmtSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(); // Create a new library object

        while (true) {
            // Display menu options
            System.out.println("\n1. Add book to library");
            System.out.println("2. Add magazine to library");
            System.out.println("3. Register a member");
            System.out.println("4. Display member details");
            System.out.println("5. Check out an item");
            System.out.println("6. Return an item");
            System.out.println("7. Display item details");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt(); // Read user input for menu option
            scanner.nextLine(); // Consume newline character

            try {
                switch (option) {
                    // Case statements for each menu option
                    case 1: // Add book
                        // Read book details from user input
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
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        Book book = new Book(id, title, author, ISBN, quantity); // Create a new book object
                        library.addItem(book); // Add book to library inventory
                        break;
                    case 2: // Add magazine
                        // Read magazine details from user input
                        System.out.println("Enter details of the magazine:");
                        System.out.print("ID: ");
                        String magazineId = scanner.nextLine();
                        System.out.print("Title: ");
                        String magazineTitle = scanner.nextLine();
                        System.out.print("Author: ");
                        String magazineAuthor = scanner.nextLine();
                        System.out.print("Issue Number: ");
                        String issueNumber = scanner.nextLine();
                        System.out.print("Quantity: ");
                        int magazineQuantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        Magazine magazine = new Magazine(magazineId, magazineTitle, magazineAuthor, issueNumber, magazineQuantity); // Create a new magazine object
                        library.addItem(magazine); // Add magazine to library inventory
                        break;
                    case 3: // Register member
                        // Read member details from user input
                        System.out.println("Enter details of the library member:");
                        System.out.print("Member ID: ");
                        String memberId = scanner.nextLine();
                        System.out.print("Member Name: ");
                        String name = scanner.nextLine();
                        LibraryMember member = new LibraryMember(memberId, name); // Create a new member object
                        library.registerMember(member); // Register member in the library
                        break;
                    case 4: // Display member details
                        // Display details of all library members
                        System.out.println("Details of the library member:");
                        for (LibraryMember i1 : library.getMembers()) {
                            String s = i1.getName();
                            String s1 = i1.getMemberId();
                            System.out.println("Name -> " + s);
                            System.out.println("Id of member -> " + s1);
                        }
                        break;
                    case 5: // Check out an item
                        // Prompt user for item ID to check out
                        System.out.println("Enter the ID of the item to be checked out:");
                        String checkoutId = scanner.nextLine();
                        for (Item item : library.getInventory()) {
                            if (item.getId().equals(checkoutId)) {
                                item.checkOut(); // Check out the item
                                break;
                            }
                        }
                        break;
                    case 6: // Return an item
                        // Prompt user for item ID to return
                        System.out.println("Enter the ID of the item to be returned:");
                        String returnId = scanner.nextLine();
                        for (Item item : library.getInventory()) {
                            if (item.getId().equals(returnId)) {
                                item.returnItem(); // Return the item
                                break;
                            }
                        }
                        break;
                    case 7: // Display item details
                        // Display details of all items in library inventory
                        System.out.println("Item Details:  ");
                        library.displayItemDetails();
                        break;
                    case 8: // Exit the program
                        System.out.println("Exiting...");
                        scanner.close(); // Close scanner
                        System.exit(0); // Exit program
                    default: // Handle invalid option
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                // Handle any exceptions
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Consume the newline character
            }
        }
    }
}
