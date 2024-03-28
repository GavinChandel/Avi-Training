package javaBasics.date_28_03_2024;

import java.util.ArrayList;

public class LongestCommonSubstring {
    public static int lcs(String str1, String str2) {
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= str1.length(); i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(str2.length() + 1);
            for (int j = 0; j <= str2.length(); j++) {
                temp.add(0);
            }
            dp.add(temp);
        }

        int ans = 0;

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp.get(i).set(j, 0);
                }
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp.get(i).set(j, dp.get(i - 1).get(j - 1) + 1);
                    ans = Math.max(ans, dp.get(i).get(j));
                }
                else {
                    dp.get(i).set(j, 0);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println(lcs(str1, str2));
    }
}
