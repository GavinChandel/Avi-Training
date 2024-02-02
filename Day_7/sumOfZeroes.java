package javaBasics.day7;

public class sumOfZeroes {

    static int add(int[][] matrix, int row, int col){
        int sum=0;
        if(row-1>=0){
            sum+=matrix[row-1][col];
        }
        if(row+1<matrix.length){
            sum+=matrix[row+1][col];
        }
        if(col-1>=0){
            sum+=matrix[row][col-1];
        }
        if(col+1<matrix[0].length){
            sum+=matrix[row][col+1];
        }

        return sum;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,0},{0,1}};
        int tsum = 0;
        for(int i=0; i< matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0) {
                    tsum += add(matrix, i, j);
                }
            }
        }
        System.out.println(tsum);
    }
}
