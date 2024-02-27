package javaBasics.date_26_02_24;

import java.util.Arrays;

public class scrambledStrings {
    public static void main(String[] args) {
        String str1 = "phqtrnilf";
        String str2 = "ilthnqrpf";

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        if(Arrays.equals(c1, c2)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
