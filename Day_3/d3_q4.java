package javaBasics;

import java.util.HashMap;

public class d3_q4 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,1};

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
            if(map.get(n)>=2){
                continue;
            }
            else{
                System.out.println(n);
            }
        }
    }
}
