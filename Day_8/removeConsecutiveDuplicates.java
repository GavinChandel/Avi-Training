package javaBasics.day8;

public class removeConsecutiveDuplicates{

    public static String removeDuplicates(String str) {
        if (str.length() <= 1) {
            return str;  // Base case: empty or single-character string
        }
        if (str.charAt(0) == str.charAt(1)) {
            return removeDuplicates(str.substring(1));  // Skip duplicates
        } else {
            return str.charAt(0) + removeDuplicates(str.substring(1));  // Keep unique characters
        }
    }

    public static void main(String[] args) {
        String input = "aabccba";
        System.out.println("Original string: " + input);
        String result = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + result);
    }
}

