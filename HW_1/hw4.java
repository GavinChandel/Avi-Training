package javaBasics;

import java.util.Scanner;

public class hw4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an odd number: ");
        int n = sc.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        if (n % 2 == 0) {
            throw new IllegalArgumentException("N must be an odd number.");
        }

        int midRow = n / 2 + 1;

        for (int i = 1; i <= n; i++) {
            int numSpaces = Math.abs(i - midRow);
            for (int j = 1; j <= numSpaces; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n - 2 * numSpaces; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


