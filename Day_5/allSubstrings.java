package javaBasics.day5;

import java.util.Scanner;

public class allSubstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String str = sc.nextLine();
        int length = str.length();

        for(int i=0; i<length; i++){
            for(int j=i+1; j<=length; j++){
                System.out.print(str.substring(i,j)+" ");
            }
        }
    }
}
