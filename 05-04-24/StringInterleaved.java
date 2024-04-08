package javaBasics.date_04_04_24;


class StringInterleaved {

    static int n, m;
    static int dp[][] = new int[100][100];
    public static int dfs(int i, int j, String A, String B, String C)
    {
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i == n && j == m)
            return 1;

        if (i < n && A.charAt(i) == C.charAt(i + j) && j < m
                && B.charAt(j) == C.charAt(i + j)) {

            int x = dfs(i + 1, j, A, B, C),
                    y = dfs(i, j + 1, A, B, C);

            return dp[i][j] = x | y;
        }

        if (i < n && A.charAt(i) == C.charAt(i + j)) {
            int x = dfs(i + 1, j, A, B, C);

            return dp[i][j] = x;
        }

        if (j < m && B.charAt(j) == C.charAt(i + j)) {
            int y = dfs(i, j + 1, A, B, C);
            return dp[i][j] = y;
        }
        return dp[i][j] = 0;
    }

    public static int isInterleave(String A, String B,
                                   String C)
    {
        n = A.length();
        m = B.length();

        if ((n + m) != C.length())
            return 0;

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = -1;

        return dfs(0, 0, A, B, C);
    }

    public static void test(String A, String B, String C)
    {
        if (isInterleave(A, B, C) != 0)
            System.out.println(1);
        else
            System.out.println(0);
    }

    public static void main(String[] args)
    {
        test("aabcc", "dbbca", "aadbbbaccc");
    }
}

