package javaBasics.date_18_03_24.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class retrieveElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Red");
        strings.add("Green");
        strings.add("Orange");
        strings.add("White");
        strings.add("Black");
        System.out.print("Enter the index: ");
        int index = sc.nextInt();
        try{
            System.out.println("Element at index "+index+" is "+strings.get(index));
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Index is greater than list size");
        }
    }
}
