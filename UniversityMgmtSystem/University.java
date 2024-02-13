package UniversityMgmtSys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// University class responsible for managing students, faculties, and courses
class University {
    // List to store students and faculties
    private List<Student> students;
    private List<Faculty> faculties;

    // Static list to store courses across all instances of University
    public static List<Course> courses;

    // Static initializer to initialize the courses list
    static {
        courses = new ArrayList<>();
    }

    // HashMap to store course details (course name, course code, credits)
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    // Constructor initializes students, faculties, and courses lists
    public University() {
        this.students = new ArrayList<>();
        this.faculties = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // Method to add a student to the students list
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to check if a course is available in the courses list
    public static boolean isCourseAvailable(Course course) {
        return courses.contains(course);
    }

    // Method to check if a student is available in the students list
    public boolean isStudentAvailable(Student student) {
        return students.contains(student);
    }

    // Method to add a faculty to the faculties list
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Method to check if a faculty is available in the faculties list
    public boolean isFacultyAvailable(Faculty faculty) {
        return faculties.contains(faculty);
    }

    // Method to remove a student from the students list
    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Method to remove a faculty from the faculties list
    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    // Method to add a course to the courses list and update the course details map
    public void addCourse(Course course) {
        ArrayList<Integer> innerList = new ArrayList<>();
        innerList.add(course.getCourseCode());
        innerList.add(course.getCredits());

        map.put(course.getCourseName(), innerList);

        courses.add(course);
    }

    // Method to remove a course from the courses list
    public void removeCourse(Course course) {
        courses.remove(course);
    }

    // Method to display details of students, faculties, and courses
    public void displayUniversityDetails() {
        System.out.println("Students:");
        for (Student student : students) {
            student.display();
        }

        System.out.println("\nFaculty:");
        for (Faculty faculty : faculties) {
            faculty.display();
        }

        System.out.println("\nCourses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Credits: " + course.getCredits());
            System.out.println();
        }
    }
}
