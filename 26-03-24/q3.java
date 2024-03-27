package javaBasics.date_26_03_24;

import java.util.Scanner;

public class q3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            System.out.print("Enter the size of the array: ");
            int N = scanner.nextInt();
            int[] arr = new int[N];
            System.out.print("Enter the elements of the array separated by space: ");
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println("Maximum sum of non-adjacent elements: " + maximumSumNoAdjacent(arr));
        }
    }

    public static int maximumSumNoAdjacent(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);

        int incl = arr[0];
        int excl = 0;
        int exclNew;
        for (int i = 1; i < n; i++) {
            exclNew = Math.max(incl, excl);


            incl = excl + arr[i];
            excl = exclNew;
        }
        return Math.max(incl, excl);
    }
}