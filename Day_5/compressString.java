package javaBasics.day5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class compressString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str =  sc.nextLine();

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for(int i=0; i<str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
            else{
                map.put(str.charAt(i), 1);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : map.keySet()) {
            ans.append(c);
            if (map.get(c) > 1) {
                ans.append(map.get(c));
            }
        }
        System.out.println(ans.toString());
    }
}
