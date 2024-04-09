package javaBasics.date_08_04_24;

import java.util.ArrayList;
import java.util.Collections;

public class SumOfFibonacci {
    public int fibsum(int A) {
        ArrayList<Long> list = new ArrayList();
        list.add(1l); list.add(2l);
        long first = 1l; long second = 2l;
        while(true){
            long cur = first + second;
            if(cur>10000000000l)
                break;
            list.add(cur);
            first = second;
            second = cur;
        }
        int ans = 0;
        long a= A;
        //System.out.println(list);
        while(a>0){
            int index = Collections.binarySearch(list, a);
            //System.out.println(a+" "+index);
            if(index>=0){
                ans++;
                return ans;
            }
            else {
                index = -(index+1);
                index--;
                a = a-list.get(index);
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SumOfFibonacci solution = new SumOfFibonacci();
        int number = 7;
        int result = solution.fibsum(number);
        System.out.println(result);
    }
}

