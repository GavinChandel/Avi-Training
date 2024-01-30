package javaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d3_q6 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,6,3,0,2,1,7};
        int target = 10;

        List<List<Integer>> triplets = findTriplets(arr, target);

        if (triplets.isEmpty()) {
            System.out.println("-1");
        } else {
            System.out.println("Triplets:");
            for (List<Integer> triplet : triplets) {
                System.out.println(triplet);
            }
        }
    }

    public static List<List<Integer>> findTriplets(int[] arr, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                int currentSum = arr[i] + arr[j] + arr[k];

                if (currentSum == target) {
                    triplets.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                } else if (currentSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return triplets;
    }
}
