package UniversityMgmtSys;

import java.util.Objects;

// Course class to represent a university course
class Course {
    // Attributes of a course
    private int courseCode; // Course code
    private String courseName; // Course name
    private int credits; // Number of credits for the course

    // Constructor to initialize course attributes
    public Course(int courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    // Getter method to retrieve the course code
    public int getCourseCode() {
        return courseCode;
    }

    // Getter method to retrieve the course name
    public String getCourseName() {
        return courseName;
    }

    // Getter method to retrieve the number of credits
    public int getCredits() {
        return credits;
    }

    // Override equals method to compare courses based on their attributes
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Course course = (Course) obj;
        return courseCode == course.courseCode && courseName.equals(course.courseName) && credits == course.credits;
    }

    // Override hashCode method to generate a hash code based on course attributes
    @Override
    public int hashCode() {
        return Objects.hash(courseCode, courseName, credits);
    }
}
