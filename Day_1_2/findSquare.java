package javaBasics;

import java.util.Scanner;

public class findSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int x = sc.nextInt();
        System.out.print("Enter the power: ");
        int n = sc.nextInt();

        System.out.println(square(x, n));

    }

    public static int square(int x, int n){
        if(n==0){
            return 1;
        }
        else if(n%2==0){
            return square(x*x, n/2);
        }
        else if(n%2==1){
            return x*square(x, n-1);
        }

        return 1/square(x, -n);
    }
}
