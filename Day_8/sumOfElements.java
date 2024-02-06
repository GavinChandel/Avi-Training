package javaBasics.day8;

public class sumOfElements{

    public static int sum(int[] arr, int n) {
        if (n == 0) {
            return 0; // Base case: empty array has sum 0
        }
        return arr[n - 1] + sum(arr, n - 1); // Recursive call and add current element
    }

    public static void main(String[] args) {
        // Sample test cases
        int[] arr1 = {9, 8, 9};
        System.out.println("Sum of arr1: " + sum(arr1, arr1.length));
    }
}

