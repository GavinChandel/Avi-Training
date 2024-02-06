package javaBasics.day9;

public class nCr {

    static int factorial(int n){
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        int n = 5;
        int r = 2;

        int ans = factorial(n)/(factorial(n-r)*factorial(r));
        System.out.println(ans);
    }
}
