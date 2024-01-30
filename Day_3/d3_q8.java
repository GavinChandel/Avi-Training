package javaBasics;

public class d3_q8 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int product = 1;

        for(int n:arr){
            product*=n;
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = product/arr[i];
        }

        System.out.print("[ ");
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.print("]");
    }
}
