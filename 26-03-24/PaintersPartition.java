package javaBasics.date_26_03_24;

class PaintersPartition{
    static int sum(int arr[], int from, int to)
    {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }

    static int partition(int arr[], int n, int k)
    {
        if (k == 1)
            return sum(arr, 0, n - 1);
        if (n == 1)
            return arr[0];

        int best = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++)
            best = Math.min(
                    best, Math.max(partition(arr, i, k - 1),
                            sum(arr, i, n - 1)));

        return best;
    }
    public static void main(String args[])
    {
        int arr[] = { 10, 20, 60, 50, 30, 40 };
        int n = arr.length;
        int k = 3;
        System.out.println(partition(arr, n, k));
    }
}
