package javaBasics;

public class d4_q8 {
    static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6,2,8,4,10};
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[i]){
                    swap(arr, i, j);
                }            }
        }
        for(int n:arr){
            System.out.print(n+" ");
        }
    }
}
