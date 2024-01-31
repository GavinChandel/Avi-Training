package javaBasics.day5;

import java.util.HashMap;
import java.util.Scanner;

public class highestOccurrence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
            else{
                map.put(str.charAt(i), 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(char c: map.keySet()){
            if(map.get(c)>max){
                max = map.get(c);
            }
        }
        for(char c: map.keySet()){
            if(map.get(c)==max){
                System.out.println(c);
                return;
            }
        }
    }
}
