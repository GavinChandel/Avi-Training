package javaBasics.day7;

import java.util.Scanner;

public class search2dMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.print("Enter the number to find: ");
        int target = sc.nextInt();
        int n = matrix[0].length-1;
        int possibleRow = 0;

        for(int i=0; i< matrix.length; i++){
            if(matrix[i][n]>target){
                possibleRow = i;
                break;
            }
            else if(matrix[i][n]==target){
                System.out.println("True");
            }
        }

        int start = 0;
        int end = n;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(matrix[possibleRow][mid]==target){
                System.out.println("True");
                return;
            }
            else if(matrix[possibleRow][mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }

        }
        System.out.println("False");
    }
}
