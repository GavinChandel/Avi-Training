package javaBasics;

import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

// Interface defining operations for managing employees
interface Employee extends Serializable {
    void addEmployee(int id, String name, String position, double salary) throws EmployeeManagementException;
    void removeEmployee(int id) throws EmployeeManagementException;
    void displayEmployeeInfo(int id) throws EmployeeManagementException;
    void displayAllEmployees();
    double calculateTotalSalary();
    void sortEmployeesBySalary();
    List<EmployeeInfo> searchEmployees(String keyword);
    void updateEmployeeInfo(int id, String name, String position, double salary) throws EmployeeManagementException;
}

// Class representing information about an employee
class EmployeeInfo implements Serializable {
    private int id;
    private String name;
    private String position;
    private double salary;

    public EmployeeInfo(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

// Class implementing the Employee interface for full-time employees
class FullTimeEmployee implements Employee {
    private List<EmployeeInfo> employees;

    public FullTimeEmployee() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(int id, String name, String position, double salary) throws EmployeeManagementException {
        // Check if employee ID already exists
        for (EmployeeInfo employee : employees) {
            if (employee.getId() == id) {
                throw new EmployeeManagementException("Employee ID already exists!");
            }
        }
        employees.add(new EmployeeInfo(id, name, position, salary));
    }

    @Override
    public void removeEmployee(int id) throws EmployeeManagementException {
        // Remove employee by ID
        boolean removed = employees.removeIf(employee -> employee.getId() == id);
        if (!removed) {
            throw new EmployeeManagementException("Employee not found!");
        }
    }

    @Override
    public void displayEmployeeInfo(int id) throws EmployeeManagementException {
        // Display information of an employee by ID
        for (EmployeeInfo employee : employees) {
            if (employee.getId() == id) {
                System.out.println(employee);
                return;
            }
        }
        throw new EmployeeManagementException("Employee not found!");
    }

    @Override
    public void displayAllEmployees() {
        // Display information of all employees
        employees.forEach(System.out::println);
    }

    @Override
    public double calculateTotalSalary() {
        // Calculate total salary of all employees
        return employees.stream().mapToDouble(EmployeeInfo::getSalary).sum();
    }

    @Override
    public void sortEmployeesBySalary() {
        // Sort employees by salary
        employees.sort(Comparator.comparingDouble(EmployeeInfo::getSalary));
    }

    @Override
    public List<EmployeeInfo> searchEmployees(String keyword) {
        // Search employees by keyword in name, position, or salary
        List<EmployeeInfo> result = new ArrayList<>();
        for (EmployeeInfo employee : employees) {
            if (employee.getName().contains(keyword) || employee.getPosition().contains(keyword) ||
                    String.valueOf(employee.getSalary()).contains(keyword)) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public void updateEmployeeInfo(int id, String name, String position, double salary) throws EmployeeManagementException {
        // Update information of an employee by ID
        for (EmployeeInfo employee : employees) {
            if (employee.getId() == id) {
                employee = new EmployeeInfo(id, name, position, salary);
                return;
            }
        }
        throw new EmployeeManagementException("Employee not found!");
    }
}

// Custom exception class for employee management
class EmployeeManagementException extends Exception {
    public EmployeeManagementException(String message) {
        super(message);
    }
}

// Main class for Employee Management System
public class EmployeeMgmtSys {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(); // Create instance of FullTimeEmployee
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        int choice = 0; // Variable to store user choice
        while (choice != 7) { // Loop until user chooses to exit
            System.out.println("\nEmployee Management System Menu:"); // Display menu options
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display Employee Information");
            System.out.println("4. Display All Employees");
            System.out.println("5. Calculate Total Salary");
            System.out.println("6. Sort Employees by Salary");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: "); // Prompt user for choice
            try {
                choice = scanner.nextInt(); // Read user choice
                scanner.nextLine(); // Consume newline

                switch (choice) { // Perform action based on user choice
                    case 1: // Add Employee
                        try {
                            System.out.print("Enter Employee ID: "); // Prompt user for employee details
                            int id = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Position: ");
                            String position = scanner.nextLine();
                            System.out.print("Enter Salary: ");
                            double salary = scanner.nextDouble();
                            fullTimeEmployee.addEmployee(id, name, position, salary); // Add employee
                            System.out.println("Employee added successfully!");
                        } catch (EmployeeManagementException e) { // Catch and handle exceptions
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2: // Remove Employee
                        System.out.print("Enter Employee ID to remove: "); // Prompt user for ID
                        int removeId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        try {
                            fullTimeEmployee.removeEmployee(removeId); // Remove employee
                            System.out.println("Employee removed successfully!");
                        } catch (EmployeeManagementException e) { // Catch and handle exceptions
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3: // Display Employee Information
                        System.out.print("Enter Employee ID: "); // Prompt user for ID
                        int displayId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        try {
                            fullTimeEmployee.displayEmployeeInfo(displayId); // Display employee info
                        } catch (EmployeeManagementException e) { // Catch and handle exceptions
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 4: // Display All Employees
                        fullTimeEmployee.displayAllEmployees(); // Display all employees
                        break;

                    case 5: // Calculate Total Salary
                        System.out.println("Total Salary: " + fullTimeEmployee.calculateTotalSalary()); // Calculate and display total salary
                        break;

                    case 6: // Sort Employees by Salary
                        fullTimeEmployee.sortEmployeesBySalary(); // Sort employees by salary
                        fullTimeEmployee.displayAllEmployees(); // Display sorted employees
                        break;

                    case 7: // Exit
                        System.out.println("Exiting..."); // Exit the program
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7."); // Handle invalid choices
                }
            } catch (java.util.InputMismatchException ex) { // Handle invalid input types
                System.out.println("Invalid input type. Please enter a valid integer choice.");
                scanner.nextLine(); // Consume newline
            }
        }
        scanner.close(); // Close scanner
    }
}
