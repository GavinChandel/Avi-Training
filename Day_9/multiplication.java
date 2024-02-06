package javaBasics.day9;

public class multiplication {
    static int multiply(int x, int y, int ans){
        if(y==0){
            return 0;
        }
        if(y==1){
            return ans;
        }
        return multiply(x, y-1, ans+x);
    }

    public static void main(String[] args) {
        int x = 12;
        int y = 8;
        System.out.println(multiply(x, y+1, 0));
    }
}
