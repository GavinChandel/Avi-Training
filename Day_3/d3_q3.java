package javaBasics;

import java.util.HashMap;

public class d3_q3 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,2,3,3,2,4,4,4};

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n:arr){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }
            else{
                map.put(n, 1);
            }
        }

        for(Integer n: map.keySet()){
            if(map.get(n)>=3){
                continue;
            }
            else{
                System.out.println(n);
            }
        }
    }
}
