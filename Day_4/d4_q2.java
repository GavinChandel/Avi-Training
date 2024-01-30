package javaBasics;

public class d4_q2 {

    static int[] merge(int[] arr1, int[] arr2){
        int[] ans = new int[arr1.length+arr2.length];
        int i=arr1.length-1, j=arr2.length-1, k=ans.length-1;

        while(j>=0){
            if(i>=0 && arr1[i]>arr2[j]){
                ans[k] = arr1[i];
                i--;
                k--;
            }
            else {
                ans[k] = arr2[j];
                j--;
                k--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = {3,5,9};
        int[] num2 = {1,2,3,8};

        int[] result = merge(num1, num2);
        for(int n:result){
            System.out.print(n+" ");

        }
    }

}
