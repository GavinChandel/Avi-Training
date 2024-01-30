package javaBasics;

import java.util.HashSet;

public class d4_q3 {

    static int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int count = 0;
        int longest = 1;
        int last = Integer.MIN_VALUE;

        for(int i:set){
            if(!set.contains(i-1)){
                count = 1;
                last = i;

                while(set.contains(last + 1)){
                    last = last+1;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,4,9,10,10,6};
        System.out.println(longestConsecutive(arr));
     }
}
