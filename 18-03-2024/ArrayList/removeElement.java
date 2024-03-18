package javaBasics.date_18_03_24.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class removeElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Red");
        strings.add("Green");
        strings.add("Orange");
        strings.add("White");
        strings.add("Black");

        System.out.println("Enter the index to be removed: ");
        int index = sc.nextInt();
        try{
            strings.remove(index);
        }
        catch(IndexOutOfBoundsException e){
            if(index<0){
                System.out.println("Index is less than 0");
            }
            else{
                System.out.println("Index is greater than list size.");
            }
        }
        System.out.println(strings);
    }
}
