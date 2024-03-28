package javaBasics.date_28_03_2024;

public class MinimumJumpsRequired{
    public static int minimumJumps(int[] arr, int N) {
        if (N == 1) {
            return 0;
        }
        if (arr[0] == 0) {
            return -1;
        }

        int jumpsTaken = 1;
        int maxReach = arr[0];
        int stepsLeft = arr[0];

        for (int i = 1; i <= (N - 2); i++) {
            maxReach = Math.max(maxReach, i + arr[i]);
            stepsLeft--;
            if (stepsLeft == 0) {
                jumpsTaken++;
                if (i >= maxReach) {
                    return -1;
                }
                stepsLeft = maxReach - i;
            }
        }
        return jumpsTaken;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        int N = arr.length;
        System.out.println(minimumJumps(arr, N));
    }
}

