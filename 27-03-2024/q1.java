package javaBasics.date_27_03_24;

public class q1{

    static int mod = (int) 1e9 + 7;

    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;

        for (int i = 0; i < n; ++i) {
            totalSum += arr[i];
        }

        if (totalSum < d || ((totalSum - d) % 2) == 1) {
            return 0;
        }

        int target = (totalSum - d) / 2;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        return countPartitionsHelper(n, target, arr, dp);
    }

    public static int countPartitionsHelper(int pos, int sum, int[] arr, int[][] dp) {
        if (pos == 0) {
            if (sum == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[pos][sum] != -1) {
            return dp[pos][sum];
        }

        dp[pos][sum] = countPartitionsHelper(pos - 1, sum, arr, dp);

        if (sum >= arr[pos - 1]) {
            dp[pos][sum] = (dp[pos][sum] +
                    countPartitionsHelper(pos - 1, sum - arr[pos - 1], arr, dp)) % mod;
        }

        return dp[pos][sum];
    }

    public static void main(String[] args) {
        int n = 4;
        int d = 1;
        int[] arr = {5,2,5,1};
        System.out.println(countPartitions(n, d, arr));
    }
}
