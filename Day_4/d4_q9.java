package javaBasics;

import java.util.HashMap;
import java.util.Scanner;

public class d4_q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,1,1,2,2,3,3};
        System.out.print("Enter the number to find: ");
        int target = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n:arr){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }
            else{
                map.put(n, 1);
            }
        }
        int ans = map.get(target);
        System.out.println(ans);

    }
}
