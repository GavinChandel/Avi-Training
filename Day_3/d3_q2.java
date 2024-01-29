package javaBasics;

import java.util.ArrayList;
import java.util.Scanner;

public class d3_q2 {

    public static void reverse(int[] arr, int start, int end){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the pivot position: ");
        int index = sc.nextInt();

        int[] arr = {1,2,3,4,5,6};

        reverse(arr, index, arr.length-1);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
