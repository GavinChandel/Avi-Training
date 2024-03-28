package javaBasics.date_28_03_2024;


public class Partition {

    public static boolean canPartition(int[] arr, int n) {
        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int subsetSum = totalSum / 2;
        boolean dp[] = new boolean[subsetSum + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = subsetSum; j >= 0; j--) {
                if (j - arr[i - 1] >= 0) {
                    dp[j] = dp[j - arr[i - 1]] || dp[j];
                }
            }
        }

        return dp[subsetSum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        int n = arr.length;
        if (canPartition(arr, n)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

