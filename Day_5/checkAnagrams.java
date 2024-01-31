package javaBasics.day5;

import java.util.Arrays;
import java.util.Scanner;

public class checkAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first word: ");
        String str1 = sc.nextLine();
        System.out.print("Enter the second word: ");
        String str2 = sc.nextLine();

        if(str1.length()!=str2.length()){
            System.out.println("false");
            return;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(Arrays.equals(arr1, arr2)){
            System.out.println("true");
        }
        else{
            System.out.println("false");

        }
    }
}
