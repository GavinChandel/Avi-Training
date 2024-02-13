package UniversityMgmtSys;

import java.util.*;

// Student class, a subclass of Person
class Student extends Person {
    // Additional attributes specific to students
    private int studentId; // Student ID
    private Map<Student, List<Course>> enrolledCourses; // Map to store enrolled courses for each student

    // Constructor to initialize student attributes
    public Student(int id, String name, int age, int studentId) {
        super(id, name, age); // Call to superclass constructor to initialize common attributes
        this.studentId = studentId;
        this.enrolledCourses = new HashMap<>();
    }

    // Getter method to retrieve the student ID
    public int getStudentId() {
        return studentId;
    }

    // Method to display student details including enrolled courses
    @Override
    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Courses Enrolled:");

        // Retrieve the list of enrolled courses for this student from the map
        List<Course> courses = enrolledCourses.getOrDefault(this, new ArrayList<>());
        for (Course course : courses) {
            System.out.println("Course Name: " + course.getCourseName());
        }
    }
}
