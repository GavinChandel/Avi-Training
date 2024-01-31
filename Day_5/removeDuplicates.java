package javaBasics.day5;

import java.util.ArrayList;
import java.util.Scanner;

public class removeDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();

        ArrayList<Character> list = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            if(list.contains(str.charAt(i))){
                continue;
            }
            else{
                list.add(str.charAt(i));
            }
        }
        for(char c:list){
            System.out.print(c+" ");
        }
    }
}
