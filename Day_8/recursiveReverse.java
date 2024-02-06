package javaBasics.day8;

public class recursiveReverse {

    static void Print(int[] n, int length) {
        if (length == 0) {  // Base case to stop recursion
            return;
        }
        System.out.print(n[length - 1] + " ");
        Print(n, length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Print(nums, nums.length);  // Call the recursive method directly
    }
}
