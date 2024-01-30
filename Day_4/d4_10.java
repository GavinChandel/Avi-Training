package javaBasics;

import java.util.Scanner;

public class d4_10 {

    static int search(int[] arr, int target, boolean findFirstIndex){
        int ans = 0;
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]>target){
                end = mid-1;
            }
            else if(arr[mid]<target){
                start = mid+1;
            }
            else if(arr[mid]==target){
                ans = mid;

                if(findFirstIndex==true){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {1, 2, 4, 4, 5};
        int[] result = new int[2];

        System.out.print("Enter the number: ");
        int target = sc.nextInt();

        int first = search(nums, target, true);
        int last = search(nums, target, false);
        result[0] = first;
        result[1] = last;

        for(int n:result){
            System.out.print(n+" ");

        }
    }
}
