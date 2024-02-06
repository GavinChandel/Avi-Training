package javaBasics.day9;

public class checkPrefix{

    public static boolean is_valid_string(String s) {
        if (s.isEmpty()) {
            return true;
        }

        if (s.length() < 2) {
            return s.charAt(0) == 'a';
        }

        if (s.charAt(0) != 'a') {
            return false;
        }

        if (s.charAt(1) == 'a') {
            return is_valid_string(s.substring(2));
        } else if (s.length() >= 3 && s.substring(1, 3).equals("bb")) { // Ensure length before accessing substring
            return is_valid_string(s.substring(3));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(is_valid_string("abababa"));
    }
}
