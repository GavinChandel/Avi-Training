package javaBasics;

import java.util.Arrays;

public class d4_q5 {

    static int[] mergeSort(int[] nums){
        if(nums.length==1){
            return nums;
        }
        int mid = nums.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];

        int i=0, j=0, k=0;

        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k] = first[i];
                i++;
            }
            else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while(i<first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 11, 6, 2, 29, 7 };
        int[] result = mergeSort(arr);
        for(int n:result){
            System.out.print(n+" ");

        }
    }
}
