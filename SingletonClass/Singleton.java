package javaBasics.Singleton;

public class Singleton {

    //the default constructor is made private, so that it can not be accessed from anywhere outside this class
    private Singleton(){
        System.out.println("Instance of the Singleton class has been created");
    }

    //creating a private instance of the Singleton class
    private static Singleton demoInstance;

    //creating a public getter method in order to return the only instance created for this class,
    //whenever this method will be called using the class name
    public static Singleton getInstance(){
        if(demoInstance==null){
            demoInstance = new Singleton();
        }
        return demoInstance;
    }
}
