package javaBasics.day6;

import java.lang.*;
import java.util.*;
public class distinctSubstrings {
    public static int minChanges(String str) {
        int n = str.length();
        if (n > 26)
            return -1;
        int dist_count = 0;
        int count[] = new int[26];
        for(int i = 0; i < 26; i++)
            count[i] = 0;
        for (int i = 0; i < n; i++) {
            if(count[str.charAt(i)-'a'] == 0) {
                dist_count++;
            }
            count[str.charAt(i)-'a']++;
        }
        return (n-dist_count);
    }
    public static void main (String[] args) {
        String str = "aebaecedabbeedee";
        System.out.println(minChanges(str));
    }
}
