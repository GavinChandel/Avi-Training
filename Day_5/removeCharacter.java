package javaBasics.day5;

import java.util.Scanner;

public class removeCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        System.out.print("Enter the character to be removed: ");
        char c = sc.next().charAt(0);
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!=c){
                ans.append(str.charAt(i));
            }
            else{
                continue;
            }
        }
        System.out.println(ans.toString());
    }
}
