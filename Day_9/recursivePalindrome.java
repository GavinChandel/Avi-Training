package javaBasics.day9;

import java.util.Scanner;

public class recursivePalindrome {

    static boolean check(String s, int index){
        if(index==s.length()/2 || s.charAt(index)!=s.charAt(s.length()-1-index)){
            return false;
        }

        if(s.charAt(index)==s.charAt(s.length()-1-index)){
            check(s, index+1);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String str = sc.nextLine();
        System.out.println(check(str, 0));
    }
}
