package javaBasics.day9;

import java.util.Scanner;

public class convertToInteger {

    static int conversion(String str, int i, int number){

        if(i==str.length()){
            return number;
        }

        int digit = str.charAt(i)-'0';
        int ans = conversion(str, i+1, number*10+digit);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string value: ");
        String str = sc.nextLine();

        System.out.print(conversion(str, 0, 0));
    }
}
