package javaBasics;

import java.util.Scanner;

public class d3_q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();
        System.out.print("Enter the value of Q: ");
        int q = sc.nextInt();

        int sum = 0;
        int product = 1;

        for(int i=1; i<=n; i++){

            if(q==1){
                sum+=i;
            }

            else{
                product*=i;
            }
        }

        if(q==1){
            System.out.println(sum);
        }
        else{
            System.out.println(product);
        }

    }
}
