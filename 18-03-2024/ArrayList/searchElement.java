package javaBasics.date_18_03_24.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class searchElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Red");
        strings.add("Green");
        strings.add("Orange");
        strings.add("White");
        strings.add("Black");
        System.out.print("Enter the element to be searched: ");
        String search = sc.nextLine();
        int index = 0;

        while(index<strings.size()){
            if(strings.get(index).equals(search)){
                System.out.println("Found the element at index "+index);
                break;
            }
            else{
                index++;
            }
            if(index==strings.size()){
                System.out.println("Element not found in the list");
            }
        }

        strings.trimToSize();
    }
}
