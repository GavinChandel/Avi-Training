package javaBasics.day7;

import java.util.PriorityQueue;

public class sortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{10, 20, 30, 40},
                          {15, 20, 35, 42},
                          {27, 29, 37, 46},
                          {32, 33, 38, 49}};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                minHeap.add(matrix[i][j]);
            }
        }
        while(!minHeap.isEmpty()){
            System.out.print(minHeap.poll()+" ");
        }
    }
}
