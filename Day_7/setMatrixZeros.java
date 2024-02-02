package javaBasics.day7;

import java.util.ArrayList;

public class setMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                          {4,0,6},
                          {7,8,9}};

        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    l1.add(i);
                    l2.add(j);
                }
            }
        }

        for(int row:l1){
            for(int col=0; col<matrix[0].length; col++){
                matrix[row][col] = 0;
            }
        }
        for(int col:l2){
            for(int row=0; row<matrix.length; row++){
                matrix[row][col] = 0;
            }
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
