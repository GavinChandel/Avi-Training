package javaBasics;

import java.util.Scanner;

public class hw5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            int sum = 0;

            // Print numbers and calculate their sum
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
                if (j < i) {
                    System.out.print("+");
                }
                sum += j;
            }

            System.out.print("=" + sum);
            System.out.println();
        }
    }
}

