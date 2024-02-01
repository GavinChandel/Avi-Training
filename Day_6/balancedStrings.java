package javaBasics.day6;

import java.util.Stack;

public class balancedStrings {
    public static void main(String[] args) {
        String str = "((()()())))))";
        Stack<Character> s = new Stack<>();

        for(char c:str.toCharArray()){
            if(c=='('){
                s.push(c);
            }
            else if(c==')' && !s.isEmpty() && s.peek()=='('){
                s.pop();
            }
            else{
                s.push(c);
            }
        }
        System.out.println(s.size());;
    }
}
