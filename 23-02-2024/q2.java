package javaBasics.date_24_02_24;

import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String str = sc.nextLine();

        int[] letterCount = new int[256];
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(Character.isLetter(c)){
                letterCount[c]++;
            }
        }

        char result = ' ';
        int max = 0;
        for(int i=0; i<letterCount.length; i++){
            if (letterCount[i] > max) {
                max = letterCount[i];
                result = (char) i;
            }
        }

        if(max==0){
            System.out.println("No letter is present in the entered string.");
            return;
        }

        System.out.println("The letter with the highest occurrence is: "+result );

    }
}

