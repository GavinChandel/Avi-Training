package javaBasics.day9;

import java.util.Scanner;

public class geometricSum {

    public static double sum(double[] arr, int n) {
        if (n == 0) {
            return 0; // Base case: empty array has sum 0
        }
        return arr[n - 1] + sum(arr, n - 1); // Recursive call and add current element
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        double[] nums = new double[n+1];
        nums[0] = 1;

        for(int i=1; i<=n; i++){
            nums[i] = 1/Math.pow(2, i);
        }

        double ans = sum(nums, nums.length);

        System.out.printf("Sum of arr1 = %.5f\n" ,ans);
    }
}
