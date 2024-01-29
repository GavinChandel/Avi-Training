package javaBasics;

import java.util.Scanner;

public class oddEvenSum {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        n = sc.nextInt();

        int evenSum = 0;
        int oddSum = 0;

        while(n>0){
            int digit = n%10;
            if(digit%2==0){
                evenSum += digit;
            }
            else{
                oddSum += digit;
            }

            n/=10;
        }
        System.out.println("Odd sum is: " + oddSum);
        System.out.println("Even sum is: " + evenSum);
    }
}
