package javaBasics.date_21_03_24;
import java.util.*;

class PreprocessingMoves
{
    static int Preprocess(String A, String B)
    {

        int n = A.length();
        int ans = 0;

        for (int i = 0; i < n / 2; i++)
        {

            HashMap<Character, Integer> mp = new HashMap<>();

            if(mp.containsKey(A.charAt(i)))
                mp.put(A.charAt(i), mp.get(A.charAt(i))+1);
            else
                mp.put(A.charAt(i), 1);

            if(mp.containsKey(A.charAt(n-i-1)))
                mp.put(A.charAt(n-i-1), mp.get(A.charAt(n-i-1))+1);
            else
                mp.put(A.charAt(n-i-1), 1);

            if(mp.containsKey(B.charAt(i)))
                mp.put(B.charAt(i), mp.get(B.charAt(i))+1);
            else
                mp.put(B.charAt(i), 1);

            if(mp.containsKey(B.charAt(n-i-1)))
                mp.put(B.charAt(n-i-1), mp.get(B.charAt(n-i-1))+1);
            else
                mp.put(B.charAt(n-i-1), 1);

            int sz = mp.size();
            if (sz == 4)
                ans += 2;

            else if (sz == 3)
                ans += 1 + (A.charAt(i) == A.charAt(n - i - 1) ? 1 : 0 );

            else if (sz == 2)
                ans += mp.get(A.charAt(i)) != 2 ? 1 : 0;
        }

        if (n % 2 == 1 && A.charAt(n / 2) != B.charAt(n / 2))
            ans++;

        return ans;
    }

    public static void main (String[] args)
    {
        String A = "zcabd", B = "dbacz";
        System.out.println(Preprocess(A, B));

    }
}
