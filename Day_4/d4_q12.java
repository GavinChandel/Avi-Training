package javaBasics;

public class d4_q12 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 1, 2, 1, 2};
        int low=0, mid=0;
        int high = nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                swap(nums, mid, high);
                high--;
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
