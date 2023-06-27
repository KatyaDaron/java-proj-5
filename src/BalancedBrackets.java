//Write a function that takes in a string and returns true or false based on whether the string’s opening-and-closing marks (that is, brackets) are balanced.
//Account for the following bracket types:
//( ); { }; [ ]; < >
//The string doesn’t need to have all four types of brackets, but if an open bracket appears, the pair should also be closed correctly.

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {
    static boolean balancedBrackets(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        map.put('<', '>');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    char top = stack.pop();
                    if (map.get(top) != c) return false;
                } else return false;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("<<>>"));
        System.out.println(balancedBrackets(""));
        System.out.println(balancedBrackets("<({})>"));
        System.out.println(balancedBrackets("<({)}>"));
    }
}
