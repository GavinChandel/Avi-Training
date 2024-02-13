package UniversityMgmtSys;

// Abstract class representing a generic person
abstract class Person {
    // Attributes common to all persons
    private int id; // Person's ID
    private String name; // Person's name
    private int age; // Person's age

    // Constructor to initialize a person's attributes
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter method for retrieving the person's age
    public int getAge() {
        return age;
    }

    // Getter method for retrieving the person's name
    public String getName() {
        return name;
    }

    // Getter method for retrieving the person's ID
    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses to display person details
    public abstract void display();
}
