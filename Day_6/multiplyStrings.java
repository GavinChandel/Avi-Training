package javaBasics.day6;

import java.util.Scanner;

public class multiplyStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String s1 = sc.nextLine();
        System.out.print("Enter the second number: ");
        String s2 = sc.nextLine();

        int num1 = 0, num2 = 0;

        for(int i=0; i<s1.length(); i++){
            int digit = s1.charAt(i)-'0';
            num1 = num1*10+digit;
        }

        for(int i=0; i<s2.length(); i++){
            int digit = s2.charAt(i)-'0';
            num2 = num2*10+digit;
        }

        int product = num1*num2;

        System.out.println(String.valueOf(product));
    }
}
