package javaBasics.day7;

public class printDiagonals {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length-i; j++){
                System.out.print(matrix[j][j+i]+" ");
            }
            System.out.println();
        }
    }
}
