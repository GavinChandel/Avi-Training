package javaBasics;

import java.util.ArrayList;
import java.util.Scanner;

public class d3_q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr={1,2,3};
        System.out.print("Enter the lower limit: ");
        int L = sc.nextInt();
        System.out.print("Enter the higher limit: ");
        int R = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<=R; i++){
            list.add(arr[i%arr.length]);
        }
        int sum = 0;
        for(int i=L; i<=R; i++){
            sum+=list.get(i);
        }
        System.out.print("Sum from index "+L+" to "+R+" is "+sum);
    }
}
