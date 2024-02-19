package javaBasics.Singleton;

public class Main {
    public static void main(String[] args) {
        //trying to create different objects of the singleton class using the getInstance method will
        //only lead to the same single object created and all the reference variables will be pointing
        //to the same object

        //Singleton obj = new Singleton(); //this statement will give an error because of the private default constructor
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();

        //despite having made 3 reference variable calls to create an object, the print statement
        //will be executed only once
    }
}
