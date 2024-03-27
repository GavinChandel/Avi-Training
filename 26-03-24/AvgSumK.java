package javaBasics.date_26_03_24;
import java.util.*;

class AvgSumK
{
    static int MAX_INDEX = 51;
    static int MAX_SUM = 2505;

    static int[][][] dp = new int[MAX_INDEX][MAX_SUM][MAX_INDEX];

    static int waysutil(int index, int sum, int count,
                        Vector<Integer> arr, int K)
    {
        if (index < 0)
        {
            return 0;
        }

        if (index == 0)
        {

            if (count == 0)
            {
                return 0;
            }
            int remainder = sum % count;

            if (remainder != 0)
            {
                return 0;
            }
            int average = sum / count;

            if (average == K)
            {
                return 1;
            }
        }

        if (dp[index][sum][count] != -1)
        {
            return dp[index][sum][count];
        }
        int dontpick = waysutil(index - 1,
                sum, count, arr, K);

        int pick = waysutil(index - 1,
                sum + arr.get(index),
                count + 1, arr, K);
        int total = pick + dontpick;

        dp[index][sum][count] = total;
        return total;
    }

    static int ways(int N, int K, int[] arr)
    {
        Vector<Integer> Arr = new Vector<>();
        Arr.add(-1);
        for (int i = 0; i < N; ++i)
        {
            Arr.add(arr[i]);
        }

        for (int i = 0; i < MAX_INDEX; i++)
        {
            for (int j = 0; j < MAX_SUM; j++)
            {
                for (int l = 0; l < MAX_INDEX; l++)
                {
                    dp[i][j][l] = -1;
                }
            }
        }
        int answer = waysutil(N, 0, 0, Arr, K);
        return answer;
    }

    public static void main(String args[])
    {
        int arr[] = {3, 6, 2, 8, 7, 6, 5, 9};
        int N = arr.length;
        int K = 5;
        System.out.println(ways(N, K, arr));
    }
}

