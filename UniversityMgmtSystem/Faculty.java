package UniversityMgmtSys;

import java.util.ArrayList;

// Faculty class, a subclass of Person
class Faculty extends Person {
    // Additional attributes specific to faculty
    private int employeeId; // Employee ID
    private String department; // Department where the faculty belongs

    // List to store subjects taught by the faculty
    ArrayList<String> subjects = new ArrayList<>();

    // Constructor to initialize faculty attributes
    public Faculty(int id, String name, int age, int employeeId, String department) {
        super(id, name, age); // Call to superclass constructor to initialize common attributes
        this.employeeId = employeeId;
        this.department = department;
    }


    // Override the display method to provide faculty-specific details
    @Override
    public void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Department: " + department);
    }
}
