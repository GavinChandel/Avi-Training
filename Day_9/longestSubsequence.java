package javaBasics.day9;

public class longestSubsequence{
    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        // Initialize dp array with 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Calculate the longest increasing subsequence lengths
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the maximum value in the dp array
        int maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 4, 11, 1, 16, 8};
        System.out.println(longestIncreasingSubsequence(nums1));
    }
}
