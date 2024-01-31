package javaBasics.day5;

import java.util.Scanner;

public class palindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        int length = str.length();
        boolean ans = true;

        for(int i=0; i<=length/2; i++){
            if(str.charAt(i)!=str.charAt(length-i-1)){
                ans = false;
            }
            else{
                continue;
            }
        }
        System.out.println(ans);
    }
}
