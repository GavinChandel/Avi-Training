package javaBasics.date_27_03_24;

class q2 {
    static int cutRod(int price[], int index, int n)
    {
        if (index == 0) {
            return n * price[0];
        }
        int notCut = cutRod(price, index - 1, n);
        int cut = Integer.MIN_VALUE;
        int rod_length = index + 1;

        if (rod_length <= n)
            cut = price[index]
                    + cutRod(price, index, n - rod_length);

        return Math.max(notCut, cut);
    }

    public static void main(String args[])
    {
        int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int size = arr.length;
        System.out.println(cutRod(arr, size - 1, size));
    }
}

