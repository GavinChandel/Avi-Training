package javaBasics;

import java.util.Scanner;

public class hw3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int N = scanner.nextInt();

        for (int i = 1; i <= N / 2 + 1; i++) {
            // Print spaces
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }

            // Print increasing numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // Print decreasing numbers (excluding the middle one if N is odd)
            for (int j = i - (N % 2 == 1 ? 1 : 0); j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
        }

        for (int i = N / 2; i >= 1; i--) {
            // Print spaces
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }

            // Print numbers (same as the first half)
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}

