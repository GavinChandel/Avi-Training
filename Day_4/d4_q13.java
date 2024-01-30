package javaBasics;

public class d4_q13 {

    public static int calculateSumDiagonalsAndBoundaries(int[][] matrix) {
        int n = matrix.length;

        // Initialize sum variable
        int totalSum = 0;

        // Add elements on the top and bottom boundaries
        totalSum += sum(matrix[0]) + sum(matrix[n - 1]);

        // Add elements on the left and right boundaries (excluding corners)
        for (int i = 1; i < n - 1; i++) {
            totalSum += matrix[i][0] + matrix[i][n - 1];
        }

        // Add elements on the main diagonal (excluding corners)
        for (int i = 1; i < n - 1; i++) {
            totalSum += matrix[i][i];
        }

        // Add elements on the secondary diagonal (excluding corners)
        for (int i = 1; i < n - 1; i++) {
            if(i==n-i-1){
                continue;
            }
            totalSum += matrix[i][n - i - 1];
        }

        return totalSum;
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int result = calculateSumDiagonalsAndBoundaries(matrix);
        System.out.println(result);
    }
}

