package javaBasics.date_28_03_2024;

public class Median {

    public static double median(int[] a, int[] b) {
        if (a.length > b.length) {
            return medianHelper(b, a);
        }

        return medianHelper(a, b);
    }

    public static double medianHelper(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int low = 0, high = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            int part = (n + m + 1) / 2 - mid;

            if (part > m) {
                low = mid + 1;
                continue;
            }

            int leftMax = 0, rightMin = 1000000001;
            if (mid > 0) {
                leftMax = Math.max(leftMax, a[mid - 1]);
            }
            if (part > 0) {
                leftMax = Math.max(leftMax, b[part - 1]);
            }
            if (mid < n) {
                rightMin = Math.min(rightMin, a[mid]);
            }
            if (part < m) {
                rightMin = Math.min(rightMin, b[part]);
            }

            if (leftMax <= rightMin) {
                if (((n + m) & 1) == 1) {
                    return leftMax;
                }
                return (leftMax + rightMin) / 2.0;
            }

            if (a[mid] < leftMax) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,4,6};
        int[] arr2 = {1,3,5};
        double medianValue = median(arr1, arr2);
        System.out.println(medianValue);
    }
}
