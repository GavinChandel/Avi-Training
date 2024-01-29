package javaBasics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class printReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        int x = 0;
        while(n>0){
            int digit = n%10;
            x = x*10+digit;
            n/=10;
        }
        System.out.print(x);
    }
}
