package javaBasics;
import java.util.Arrays;
import java.util.ArrayList;

public class reverseArray {

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        reversing(arr);
        for(int num:arr){
            System.out.print(num + " ");
        }

    }

    public static void reversing(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start<end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
