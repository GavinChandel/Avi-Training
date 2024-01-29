package javaBasics;
import java.util.Scanner;

public class toggleCases {

    static String toggle(String s){
        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                str.append(Character.toLowerCase(c));
            }
            else if(Character.isLowerCase(c)){
                str.append(Character.toUpperCase(c));
            }
            else{
                str.append(c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "avghgfh$$4#";
        System.out.println(toggle(s));
    }
}
