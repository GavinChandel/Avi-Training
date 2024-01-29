package javaBasics;

import java.util.Scanner;

public class hw2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the upper limit N: ");
        int N = scanner.nextInt();

        System.out.println("Prime numbers between 2 and " + N + " are:");


        for (int num = 2; num < N; num++) {
            boolean isPrime = true;

            // Check divisibility only up to the square root of num
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(num);
            }
        }
    }
}

