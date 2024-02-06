package javaBasics.day9;


public class removeDuplicates{


    public static String removeAdjacentDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean found = false;
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                found = true;
                break;
            }
        }
        if (found) {
            return removeAdjacentDuplicates(sb.toString());
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String input = "azxxzy";
        String output = removeAdjacentDuplicates(input);
        System.out.println(output);
    }

}
