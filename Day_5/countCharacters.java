package javaBasics.day5;

import java.util.Scanner;

public class countCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the sentence: ");
        String str = sc.nextLine();
        String[] ans = str.split("\s");
        System.out.println(ans.length);
    }
}
