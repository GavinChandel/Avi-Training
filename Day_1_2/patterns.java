package javaBasics;

public class patterns {
    public static void main(String[] args) {
        pattern1(4);
        pattern2(4);
        pattern3(4);
        pattern4(4);
        pattern5();

    }

    static void pattern1(int n){
        for(int i=1; i<=n; i++){
            System.out.println("4321");

        }
        System.out.println();
    }

    static void pattern2(int n){

        for(int row=1; row<=n; row++){
            for(int col=1; col<=row; col++){
                System.out.print(col);
            }

            System.out.println();
        }
        System.out.println();
    }

    static void pattern3(int n){
        for(int row=n; row>=1; row--){
            for(int col=1; col<=row; col++){
                System.out.print(row);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void pattern4(int n){

        for(int row=1; row<=4; row++){
            for(int col=1; col<=row; col++){
                System.out.print(row);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void pattern5(){
        int num = 1;
        int count = 1;

        for(int row=1; row<=4; row++){
            for(int col=1; col<=row; col++){
                System.out.print(num);
                num++;
                if(num==10){
                    num=0;
                }

            }
            System.out.println();
        }
    }
}
