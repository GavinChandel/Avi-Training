package javaBasics.day8;

public class countDigitsRecursion{

    public static int countDigits(int n) {
        if (n == 0) {
            return 1; // Base case: 0 has 1 digit
        }
        return 1+countDigits(n / 10); // Recursive call and add 1 for current digit
    }

    public static void main(String[] args) {
        // Test cases
        int number = 675321;
        System.out.println("Number of digits in " + number + ": " + (countDigits(number)-1));

    }
}

