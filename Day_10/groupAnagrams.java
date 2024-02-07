package javaBasics.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class groupAnagrams {

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String, ArrayList<String>> anagramGroups = groupAnagrams(words);

        for (ArrayList<String> group : anagramGroups.values()) {
            System.out.println(group);
        }
    }

    //this function checks every word, and then maps them to a new arraylist if not already present in the map,
    //or adds them to an already existing arraylist of the previous anagram
    private static HashMap<String, ArrayList<String>> groupAnagrams(String[] words) {
        HashMap<String, ArrayList<String>> anagramGroups = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            anagramGroups.putIfAbsent(sortedWord, new ArrayList<>());
            anagramGroups.get(sortedWord).add(word);
        }

        return anagramGroups;
    }
}
