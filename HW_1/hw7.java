package javaBasics;

import java.util.Scanner;

public class hw7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int N = scanner.nextInt();


        for (int i = N; i >= 1; i--) {

            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }


            if (i > 1) {
                System.out.print("*");
            }


            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}

