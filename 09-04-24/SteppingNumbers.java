package javaBasics.date_09_04_24;

class SteppingNumbers {
    public static void dfs(int n,int m,int stepNum)
    {
        if (stepNum <= m && stepNum >= n)
            System.out.print(stepNum + " ");

        if (stepNum == 0 || stepNum > m)
            return ;

        int lastDigit = stepNum % 10;

        int stepNumA = stepNum*10 + (lastDigit-1);
        int stepNumB = stepNum*10 + (lastDigit+1);

        if (lastDigit == 0)
            dfs(n, m, stepNumB);

        else if(lastDigit == 9)
            dfs(n, m, stepNumA);
        else
        {
            dfs(n, m, stepNumA);
            dfs(n, m, stepNumB);
        }
    }

    public static void displaySteppingNumbers(int n, int m)
    {
        for (int i = 0 ; i <= 9 ; i++)
            dfs(n, m, i);
    }

    public static void main(String args[])
    {
        int A = 10, B = 20;

        displaySteppingNumbers(A,B);
    }
}

