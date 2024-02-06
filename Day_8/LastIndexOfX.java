package javaBasics.day8;

public class LastIndexOfX {

    public static int lastIndexOfX(int[] arr, int x, int n) {
        if (n == 0) {
            return -1; // Base case: empty array
        } else if (arr[n - 1] == x) {
            return n - 1; // x found at the last position
        } else {
            int result = lastIndexOfX(arr, x, n - 1); // Recursive call for remaining elements
            return result; // Return result from recursive call
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 9, 8, 10, 8, 11, 14};
        int x = 11;
        int n = arr.length;
        System.out.println("Last index of " + x + ": " + lastIndexOfX(arr, x, n));
    }
}


