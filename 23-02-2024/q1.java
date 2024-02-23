package javaBasics.date_24_02_24;

import java.util.LinkedList;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String str = sc.nextLine();
        int start;
        int last;

        do {
            System.out.print("Enter the start index: ");
            start = sc.nextInt();
        }
        while (start<0 || start>str.length()-1);

        do {
            System.out.print("Enter the last index: ");
            last = sc.nextInt();
        }
        while (last<start || last>str.length());

        LinkedList<Character> ll = new LinkedList<>();
        for(int i=0; i<str.length(); i++){
            ll.add(str.charAt(i));
        }

        for(int i=start; i<=last; i++){
            System.out.print(ll.get(i));
        }

    }
}
