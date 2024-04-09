package javaBasics.date_08_04_24;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinsInALine {
    public int maxcoin(ArrayList<Integer> A) {
        int n = A.size();
        int[][] dp = new int[n][n];
        for(int[] arr : dp) {
            Arrays.fill(arr,-1);
        }
        return recur(dp,A,0,n-1);
    }

    int recur(int[][] dp, ArrayList<Integer> A, int start, int end) {
        if(start > end) {
            return 0;
        }

        if(dp[start][end] != -1) {
            return dp[start][end];
        }

        dp[start][end] = Math.max(A.get(start) + Math.min(recur(dp, A, start+2, end), recur(dp, A, start+1, end-1)),
                A.get(end) + Math.min(recur(dp, A, start+1, end-1), recur(dp, A, start, end-2)));
        return dp[start][end];
    }

    public static void main(String[] args) {
        ArrayList<Integer> coins = new ArrayList<>();
        coins.add(5);
        coins.add(4);
        coins.add(8);
        coins.add(10);

        CoinsInALine result = new CoinsInALine();
        System.out.println(result.maxcoin(coins));
    }
}

