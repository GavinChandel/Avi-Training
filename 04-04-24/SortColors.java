package javaBasics.date_04_04_24;

class SortColors {
    public static void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
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
            else{
                swap(nums, high, mid);
                high--;
            }
        }

    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,0,1,2};
        sortColors(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
}
