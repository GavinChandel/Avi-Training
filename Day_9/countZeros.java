package javaBasics.day9;

import java.util.Scanner;

public class countZeros{

    private static int countZeros(int num) {
        if (num == 0) {
            return 1; // Base case: reached end
        }
        if (num < 10) {
            return 0; // Count current zero and continue
        }
        int last = num%10;
        int count = countZeros(num/10);

        if(last==0){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int zeroCount = countZeros(num);
        System.out.println(zeroCount);
    }
}
