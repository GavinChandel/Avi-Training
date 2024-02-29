package javaBasics.date_29_02_24;

public class MaxConsecutiveOnesIndex {

    static int calculate(int a[], int n, int k) {
        int zeroCount = 0;
        int left = 0;
        int max_len = 0;
        int startIdx = 0; // Starting index of the longest subsequence
        int endIdx = 0;   // Ending index of the longest subsequence

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (a[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            if (i - left + 1 > max_len) {
                max_len = i - left + 1;
                startIdx = left;  // Update start index of the longest subsequence
                endIdx = i;       // Update end index of the longest subsequence
            }
        }

        // Print indices of the elements forming the longest subsequence
        for (int i = startIdx; i <= endIdx; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // Print a new line after printing indices

        return max_len;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 0, 1, 0, 1, 0, 1 };
        int k = 2;
        int n = nums.length;

        System.out.println(calculate(nums, n, k));
    }
}
