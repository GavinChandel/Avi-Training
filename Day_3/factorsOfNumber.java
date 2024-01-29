package javaBasics;

import java.util.ArrayList;
import java.util.Scanner;

public class factorsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2; i<=n/2; i++){
            if(n%i==0){
                list.add(i);
            }
        }

        if(list.isEmpty()){
            System.out.println("-1");
        }
        else{
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }
        }
    }
}
