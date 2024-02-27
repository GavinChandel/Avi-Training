package javaBasics.date_26_02_24;

public class gasStations {
    public static void main(String[] args) {
        int[] A = {1,2,3};
        int[] B = {1,2,4};

        int fuel = 0;
        int rem_fuel = 0;
        int pos = 0;

        for (int i = 0; i < A.length; i++) {
            int diff = A[i]-B[i];

            if(rem_fuel>=0){
                rem_fuel = rem_fuel+diff;
            }
            else{
                rem_fuel = diff;
                pos = i;
            }
            fuel = fuel+diff;
        }
        if(fuel>=0){
            System.out.println(pos);
        }
        else{
            System.out.println(-1);
        }
    }
}
