package javaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class d4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {3,2,1,4};
        System.out.print("How many elements do you want to print: ");
        int num = sc.nextInt();
        if(num>arr.length){
            System.out.println("Not enough elements");
            return;
        }

        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=arr.length-1; i>=0; i--){
            if(num>0){
                list.add(0,arr[i]);
                num--;
            }

        }

        for(int n:list){
            System.out.print(n+" ");
        }
    }
}
