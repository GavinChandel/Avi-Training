package javaBasics;

import java.util.Scanner;

public class hw6 {
    public static boolean isPalindrome(int n) {
        // Handle negative numbers and numbers ending in 0 (except 0 itself)
        if (n < 0 || (n % 10 == 0 && n != 0)) {
            return false;
        }

        int reversedN = 0;
        int originalN = n;

        // Reverse the number
        while (n != 0) {
            int digit = n % 10;
            reversedN = reversedN * 10 + digit;
            n /= 10;
        }

        // Check if the reversed number is equal to the original number
        return reversedN == originalN;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to be checked: ");
        int num = sc.nextInt();
        System.out.println(isPalindrome(num));
    }
}
