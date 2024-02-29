package javaBasics.date_28_02_24;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

    // Function to calculate the largest area of a rectangle
    public static int caclculateArea(int[] heights){
        int n = heights.length;
        int[] lbound = new int[n];  // Array to store the left boundary of each bar
        int[] rbound = new int[n];  // Array to store the right boundary of each bar

        Stack<Integer> st = new Stack<>();  // Stack to store indices of bars

        // Finding left boundaries for each bar
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();  // Pop the stack until the current bar's height is greater than the height of the bar at the top of the stack
            }

            if(st.isEmpty()){
                lbound[i]=0;  // If the stack is empty, there's no bar to the left, so set the left boundary to 0
            }
            else{
                lbound[i] = st.peek()+1;  // Otherwise, set the left boundary to the index of the bar at the top of the stack plus 1
            }
            st.push(i);  // Push the current bar's index onto the stack
        }

        while(!st.isEmpty()){
            st.pop();  // Empty the stack
        }

        // Finding right boundaries for each bar
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();  // Pop the stack until the current bar's height is greater than the height of the bar at the top of the stack
            }
            if(st.isEmpty()){
                rbound[i] = n-1;  // If the stack is empty, there's no bar to the right, so set the right boundary to the last index of the array
            }
            else{
                rbound[i] = st.peek()-1;  // Otherwise, set the right boundary to the index of the bar at the top of the stack minus 1
            }
            st.push(i);  // Push the current bar's index onto the stack
        }

        int maxArea = 0;

        // Calculate the area of the largest rectangle
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, heights[i]*(rbound[i]-lbound[i]+1));  // Update maxArea by taking the maximum of the current maxArea and the area of the rectangle formed by the current bar and its boundaries
        }
        return maxArea;  // Return the maximum area
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array A: ");
        int n = sc.nextInt();
        int[] A = new int[n];

        System.out.print("Enter the array elements: ");
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();  // Input the elements of the array
        }

        System.out.println(caclculateArea(A));  // Calculate and print the largest rectangle's area

    }
}
