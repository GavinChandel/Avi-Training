package javaBasics.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class Item
abstract class Item {
    private String id;
    private String title;
    private String author;
    private boolean checkedOut;
    private int quantity; // Add quantity field

    // Constructor
    public Item(String id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity; // Set quantity
        this.checkedOut = false;
    }


    // Getters
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
            quantity--;
            checkedOut = true;
            System.out.println('"'+title+'"'+ " has been checked out.");
        } else {
            System.out.println("Sorry, " +'"' +title +'"'+ " is out of stock.");
        }
    }

    // Method to return the item
    public void returnItem() {
        if (checkedOut) {
            quantity++;
            checkedOut = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " is already in the library.");
        }
    }

    // Abstract method to display item details
    public abstract void displayDetails();
}

// Book class inheriting from Item
class Book extends Item {
    private String ISBN;

    // Constructor
    public Book(String id, String title, String author, String ISBN, int quantity) {
        super(id, title, author, quantity);
        this.ISBN = ISBN;
    }

    // Override displayDetails method
    @Override
    public void displayDetails() {
        System.out.println("ID- " + getId()+", Title- " + getTitle()+", Author- " + getAuthor()+", ISBN- " + ISBN+", Quantity- " + getQuantity());
    }
}
// LibraryMember class
class LibraryMember {
    private String memberId;
    private String name;

    // Constructor
    public LibraryMember(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Getters
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
    private List<Item> inventory;
    private List<LibraryMember> members;

    // Constructor
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

    // Method to display item details
    public void displayItemDetails() {
        for (Item item : inventory) {
            item.displayDetails();
        }
    }

    // Method to get the inventory
    public List<Item> getInventory() {
        return inventory;
    }

    public List<LibraryMember> getMembers(){
        return members;
    }
}

public class LibraryMgmtSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n1. Add item to library");
            System.out.println("2. Register a member");
            System.out.println("3. Display members");
            System.out.println("4. Check out an item");
            System.out.println("5. Return an item");
            System.out.println("6. Display item details");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            try {
                switch (option) {
                    case 1:
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
                        Book book = new Book(id, title, author, ISBN,quantity);
                        library.addItem(book);
                        System.out.println("Item added successfully!!!");
                        break;
                    case 2:
                        System.out.println("Enter details of the library member:");
                        System.out.print("Member ID: ");
                        String memberId = scanner.nextLine();
                        System.out.print("Member Name: ");
                        String name = scanner.nextLine();
                        LibraryMember member = new LibraryMember(memberId, name);
                        library.registerMember(member);
                        System.out.println("Member added successfully!!!");
                        break;
                    case 3:
                        System.out.println("Members:");
                        for (LibraryMember member1:library.getMembers()) {
                            String id1 = member1.getMemberId();
                            String s = member1.getName();
                            System.out.println(id1+" "+s);
                        }case 4:
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
                        System.out.println("Item Details:");
                        library.displayItemDetails();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
