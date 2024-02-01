package javaBasics.day6;

import java.util.Scanner;

public class similarStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine();

        if(str1.equals(str2)){
            System.out.println(1);
            return;
        }

        int length = str1.length();
        String a1 = str1.substring(0, length/2);
        String a2 = str1.substring(length/2, length);
        String b1 = str2.substring(0, length/2);
        String b2 = str2.substring(length/2, length);

        if(a1.equals(b1) && a2.equals(b2)){
            System.out.println(1);
        }
        else if(a1.equals(b2) && a2.equals(b1)) {
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
