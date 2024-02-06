package javaBasics.day9;

public class reversePower{
    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        int number = 57;
        int result = powerOfReverse(number);
        System.out.println("The value of " + number + " raised to its reverse is: " + result);
    }

    public static int powerOfReverse(int num) {
        int reverse = reverseNumber(num);
        return power(num, reverse);
    }

    public static int reverseNumber(int num) {
        int reverse = 0;
        int x = num;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse;
    }

    public static int power(int x, int n) {

        if(n==0) return 1;

        if(n%2==0){
            return power(x*x, n/2);
        }
        if(n%2==1){
            return x*power(x, n-1);
        }
        return 1/power(x, -n);

    }
}
