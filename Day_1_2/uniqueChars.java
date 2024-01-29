package javaBasics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class uniqueChars {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input string: ");
        String s = sc.nextLine();

        HashMap<Character, Integer> map =  new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i), 1);
            }
        }

        for(char c:map.keySet()){
            if(map.get(c)==1){
                System.out.print(c);
            }
        }

    }
}
