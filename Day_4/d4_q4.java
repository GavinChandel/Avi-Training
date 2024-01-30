package javaBasics;

import java.util.*;

public class d4_q4 {

    static int getMaxIndex(int[] arr, int start, int end){
        int max = start;
        for(int i=start; i<=end; i++){
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6,2,8,4,10};
        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            int last = nums.length-i-1;
            int maxIndex = getMaxIndex(nums, 0, last);
            swap(nums, maxIndex, last);

        }

        for(int n:nums){
            System.out.print(n+" ");
        }
    }
}
