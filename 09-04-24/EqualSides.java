package javaBasics.date_09_04_24;

import java.util.ArrayList;
import java.util.HashSet;

public class EqualSides {
    public static ArrayList<Integer> equal(ArrayList<Integer> a) {
        int len=a.size();
        ArrayList<Integer> res = new ArrayList<>(4);
        HashSet<Integer> hs = new HashSet<>(a);
        for(int i=0; i<len-1; i++) {
            for(int j=i+1; j<len; j++) {
                for(int k=i+1; k<len-1; k++) {
                    if(j==k)
                        continue;
                    int x=a.get(i)+a.get(j)-a.get(k);
                    if(hs.contains(x)) {
                        int y;
                        for(int m=k+1; m<len; m++)
                            if(a.get(m)==x && m!=j) {
                                res.add(i);
                                res.add(j);
                                res.add(k);
                                res.add(m);
                                return res;
                            }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,7,1,2,9,8};
        ArrayList<Integer> input = new ArrayList<>();
        for(int i:arr){
            input.add(i);
        }
        ArrayList<Integer> result = equal(input);
        System.out.println(result);
    }
}



