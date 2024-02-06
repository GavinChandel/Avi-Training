package javaBasics.day9;

public class recursiveSum {

    static int sum(int num, int ans){
        if(num==0){
            return ans;
        }
        return sum(num/10, ans+num%10);
    }

    public static void main(String[] args) {
        int num = 33834;
        System.out.println(sum(num, 0));
    }
}
