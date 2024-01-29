package javaBasics;

public class tempConverter {

    public static void main(String[] args) {
        double sFahranheit = 0;
        double eFahranheit = 100;
        double stepSize = 10;

        for(double i=sFahranheit; i<=eFahranheit; i+=stepSize){
            double celsius = (i-32)*5/9;
            System.out.printf("%-20.2f" + " ",celsius);
        }
    }
}
