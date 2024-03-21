package javaBasics.date_21_03_24;

import java.util.ArrayList;
import java.util.List;

public class SearchPattern {
    public static List< Integer > stringMatch(String text, String pattern){
        int n = text.length(), m = pattern.length();

        List< Integer > ans = new ArrayList<>();
        for (int i = 0; i <= n - m; i++)
        {
            boolean match = true;

            for (int j = 0; j < m; j++)
            {
                if (text.charAt(i + j) != pattern.charAt(j))
                {
                    match = false;
                    break;
                }
            }

            if (match)
            {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String text = "cxyzghxyzvjkxyz";
        String pattern = "xyz";

        System.out.println(stringMatch(text, pattern));
    }
}
