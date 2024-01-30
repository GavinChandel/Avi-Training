package javaBasics;

import java.util.Scanner;

public class d4_q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,4,7};
        System.out.print("Enter the number to find or insert: ");
        int target = sc.nextInt();

        int size = arr.length;
        int start = 0;
        int end = size-1;
        int index=size;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                System.out.print(mid);
                 break;
            }
            else if(arr[mid]>target){
                index = mid;
                end = mid-1;
            }
            else if(arr[mid]<target){
                start = mid+1;
            }


        }
        System.out.println(index);
    }
}
