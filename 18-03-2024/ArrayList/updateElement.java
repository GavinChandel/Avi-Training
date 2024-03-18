package javaBasics.date_18_03_24.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class updateElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Red");
        strings.add("Green");
        strings.add("Orange");
        strings.add("White");
        strings.add("Black");
        System.out.print("Enter the updated string: ");
        String update = sc.next();
        System.out.print("Enter the index to be updated: ");
        int index = sc.nextInt();
        try{
            strings.remove(index);
            strings.add(index,update);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Index is greater than array length");
        }

        System.out.println(strings);
    }
}
