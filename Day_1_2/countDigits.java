package javaBasics;

public class countDigits {
    public static void main(String[] args) {
        int input= -1234;
        int count = 0;
        int x = input;
        if(input==0)
        {
            System.out.println(1);
        }
        while(x!=0)
        {
            x = x/10;
            count++;
        }
        System.out.println(count);
    }
}
