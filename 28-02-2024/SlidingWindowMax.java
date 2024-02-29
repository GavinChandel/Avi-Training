package javaBasics.date_28_02_24;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SlidingWindowMax {
    // Method to find the maximum value in each sliding window of size 'k'
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // Using a deque to store indices of elements
        Deque<Integer> q = new ArrayDeque<>();
        int j = 0; // Index for storing elements in the 'ans' array
        int ans[] = new int[nums.length - k + 1]; // Array to store maximum values in each window
        int i = 0; // Index for iterating over the 'nums' array

        // Processing the first window separately
        for (i = 0; i < k; i++) {
            // Removing indices of elements smaller than or equal to the current element from the deque
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i); // Adding the current index to the deque
        }

        // Processing the rest of the array to find maximum values in each window
        for (int index = i; index < nums.length; index++) {
            ans[j++] = nums[q.peek()]; // Storing the maximum value of the current window

            // Removing indices that are outside the current window from the deque
            while (!q.isEmpty() && q.peek() <= index - k) {
                q.removeFirst();
            }

            // Removing indices of elements smaller than or equal to the current element from the deque
            while (!q.isEmpty() && nums[index] >= nums[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(index); // Adding the current index to the deque
        }

        ans[j] = nums[q.peek()]; // Storing the maximum value of the last window
        return ans; // Returning the array containing maximum values in each window
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7}; // Input array
        System.out.print("Enter the window size: ");
        int windowSize = sc.nextInt(); // Input window size

        // Calling the maxSlidingWindow method to find maximum values in each window and printing them
        for (int i : maxSlidingWindow(arr, windowSize)) {
            System.out.print(i + " ");
        }
    }
}
