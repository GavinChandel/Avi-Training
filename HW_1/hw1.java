package javaBasics;

import java.util.Scanner;

public class hw1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        String binary = "";


        while (decimal > 0) {
            binary = decimal % 2 + binary;
            decimal /= 2;
        }

        System.out.println("Binary equivalent: " + binary);
    }
}

