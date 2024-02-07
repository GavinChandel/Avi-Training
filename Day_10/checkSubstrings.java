package javaBasics.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class checkSubstrings {

    static HashMap<String, Boolean> map = new HashMap<>();//declaring a hashmap to avoid re-iterating for the same word
    static boolean check(String str, List<String> wordList){
        if(wordList.contains(str)){
            return true;//returns true directly if the complete word is present
        }

        if(map.containsKey(str)){
            return map.get(str);//checks the map if the word has already been checked for
        }

        for(int i=0; i<=str.length(); i++){
            String left = str.substring(0, i);//creating substrings for checking
            if(wordList.contains(left) && check(str.substring(i), wordList)){  //in case both the parts of the word are present, which is checked recursively
                map.put(str.substring(i), true);                              //then we add both the left and right part to the map, with true values, and scale back
                map.put(left, true);
                return true;
            }
        }
        map.put(str, false);//in case the current word is not present, add false to the current word and put in map
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        String str = "jammukashmirjammukashmir";
        wordList.add("jammu");
        wordList.add("kashmir");
        System.out.println(check(str, wordList));
        
    }
}
