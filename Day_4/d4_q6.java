package javaBasics;

public class d4_q6 {

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};

        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(nums[j-1]>nums[j]){
                    swap(nums, j, j-1);
                }
                else{
                    break;
                }
            }
        }

        for(int n:nums){
            System.out.print(n+" ");
        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
