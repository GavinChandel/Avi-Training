package javaBasics.day8;

public class removeX {

    public static String remove(String str) {
        if (str.isEmpty()) {
            return ""; // Base case: empty string
        }
        char first = str.charAt(0);
        String rest = str.substring(1);
        return first == 'x' ? remove(rest) : first + remove(rest);
    }

    public static void main(String[] args) {
        // Sample test cases
        String input = "xaxb";
        System.out.println("Output: " + remove(input));
        System.out.println();

    }
}
