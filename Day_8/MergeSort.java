package javaBasics.day8;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);  // Sort first half
            mergeSort(arr, m + 1, r);  // Sort second half
            merge(arr, l, m, r);  // Merge sorted halves
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary subarrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy elements into subarrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        // Merge subarrays back into arr
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements (if any)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 13, 4, 1, 3, 6, 28};
        int l = 0;
        int r = arr.length - 3;
        mergeSort(arr, l, r);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

