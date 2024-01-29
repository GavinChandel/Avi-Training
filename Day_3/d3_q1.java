package javaBasics;

import java.util.ArrayList;
import java.util.Scanner;

public class d3_q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.print("Enter the number of inputs: ");
        int length = sc.nextInt();

        for(int i=0; i<length; i++){
            arr.add(sc.nextInt());
        }
        int sum = 0;
        for(int n:arr){
            sum+=n;
        }
        System.out.println("The sum of the numbers is: "+sum);
    }
}
