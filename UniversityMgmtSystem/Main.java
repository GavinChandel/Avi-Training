package UniversityMgmtSys;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a University object to manage university-related operations
        University university = new University();
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Menu loop to display options and perform actions
        while (true) {
            System.out.println("\nUniversity Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Faculty");
            System.out.println("3. Add Course");
            System.out.println("4. Display University Details");
            System.out.println("5. Remove Course");
            System.out.println("6. Remove Student");
            System.out.println("7. Remove Faculty");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Adding a student
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int studentAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student's Course (e.g., Computer Science): ");
                    String studentCourse = scanner.nextLine();

                    // Checking if the course exists in the University
                    if (University.map.containsKey(studentCourse)) {
                        Course course1 = new Course(University.map.get(studentCourse).get(0), studentCourse, University.map.get(studentCourse).get(1));

                        // Checking if the course is registered in the university
                        if (University.courses.contains(course1)) {
                            Student student = new Student(studentId, studentName, studentAge, studentId);
                            university.addStudent(student);
                            System.out.println("Student added successfully!");
                        } else {
                            System.out.println("No such course available!!!");
                        }
                    } else {
                        System.out.println("No such course exists!!!");
                    }
                    break;

                case 2:
                    // Adding a faculty
                    System.out.print("Enter Faculty ID: ");
                    int facultyId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Faculty Name: ");
                    String facultyName = scanner.nextLine();
                    System.out.print("Enter Faculty Age: ");
                    int facultyAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Faculty Employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Faculty Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter the assigned course: ");
                    String assgSub = scanner.nextLine();

                    Faculty faculty = new Faculty(facultyId, facultyName, facultyAge, employeeId, department);
                    university.addFaculty(faculty);
                    System.out.println("Faculty added successfully!");
                    break;

                case 3:
                    // Adding a course
                    System.out.print("Enter Course Code: ");
                    int courseCode = scanner.nextInt();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.next();
                    System.out.print("Enter Course Credits: ");
                    int credits = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Course course = new Course(courseCode, courseName, credits);
                    university.addCourse(course);
                    System.out.println("Course added successfully!");
                    break;

                case 4:
                    // Displaying university details
                    university.displayUniversityDetails();
                    break;

                case 5:
                    // Removing a course
                    System.out.print("Enter Course Code: ");
                    int courseCode1 = scanner.nextInt();
                    System.out.print("Enter Course Name: ");
                    String courseName1 = scanner.nextLine();
                    System.out.print("Enter Course Credits: ");
                    int credits1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Course courseToRemove = new Course(courseCode1, courseName1, credits1);

                    if (University.isCourseAvailable(courseToRemove)) {
                        university.removeCourse(courseToRemove);
                        System.out.println("Course removed successfully!");
                    } else {
                        System.out.println("Course not available in the university!");
                    }
                    break;

                case 6:
                    // Removing a student
                    System.out.print("Enter Student ID: ");
                    int studentId1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String studentName1 = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int studentAge1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student's Course (e.g., Computer Science): ");
                    String studentCourse1 = scanner.nextLine();

                    Student student1 = new Student(studentId1, studentName1, studentAge1, studentId1);
                    if (university.isStudentAvailable(student1)) {
                        university.removeStudent(student1);
                        System.out.println("Student removed successfully!");
                    } else {
                        System.out.println("Student not available in the university!");
                    }

                    break;

                case 7:
                    // Removing a faculty
                    System.out.print("Enter Faculty ID: ");
                    int facultyId1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Faculty Name: ");
                    String facultyName1 = scanner.nextLine();
                    System.out.print("Enter Faculty Age: ");
                    int facultyAge1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Faculty Employee ID: ");
                    int employeeId1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Faculty Department: ");
                    String department1 = scanner.nextLine();

                    Faculty faculty1 = new Faculty(facultyId1, facultyName1, facultyAge1, employeeId1, department1);

                    if (university.isFacultyAvailable(faculty1)) {
                        university.removeFaculty(faculty1);
                        System.out.println("Faculty removed successfully!");
                    } else {
                        System.out.println("Faculty not available in the university!");
                    }
                    break;

                case 8:
                    // Exiting the program
                    System.out.println("Exiting University Management System...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }
}
