package javaBasics.day9;

import java.util.Scanner;

public class stringSeparation {

    static String separate(String str, int index, StringBuilder res){
        if(index==str.length()){
            return str;
        }

        if(str.charAt(index)==str.charAt(index-1)){
            res.append('*');
            res.append(str.charAt(index));
        }
        else{
            res.append(str.charAt(index));
        }
        separate(str, index+1, res);

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        StringBuilder res = new StringBuilder();
        res.append(str.charAt(0));

        System.out.println(separate(str, 1, res));
    }
}
