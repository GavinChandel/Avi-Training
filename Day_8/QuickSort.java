package javaBasics.day8;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] input, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(input, start, end);
            quickSort(input, start, pivotIndex - 1);
            quickSort(input, pivotIndex + 1, end);
        }
    }

    public static int partition(int[] input, int start, int end) {
        // Choose the rightmost element as the pivot
        int pivot = input[end];
        int i = (start - 1);

        for (int j = start; j < end; j++) {
            if (input[j] <= pivot) {
                i++;
                // Swap input[i] and input[j]
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }

        // Swap input[i + 1] and input[end] (or pivot)
        int temp = input[i + 1];
        input[i + 1] = input[end];
        input[end] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] input = {2, 6, 8, 5, 4, 3};
        int start = 0;
        int end = input.length - 1;
        quickSort(input, start, end);
        System.out.println("Sorted array: " + Arrays.toString(input));
    }
}

