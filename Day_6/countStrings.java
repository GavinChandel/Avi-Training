package javaBasics.day6;

import java.util.Scanner;

public class countStrings {

    static int count(int n, int bCount, int cCount){
        if(bCount<0 || cCount <0){
            return 0;
        }
        else if(n==0){
            return 1;
        }

        int result = count(n-1, bCount, cCount);
        result += count(n-1, bCount-1, cCount);
        result += count(n-1, bCount, cCount-1);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the string: ");
        int n = sc.nextInt();

        System.out.println(count(n, 1, 2));
    }
}
