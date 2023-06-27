//Write a function that takes in a string and returns true or false depending on whether that string has balanced parentheses.
//A string has balanced parentheses if every opening parenthesis “(“ has a matching closing parenthesis “)” that closes the corresponding opening parenthesis.
//For the purposes of this problem, you only need to worry about parentheses “(“and “)”, not other opening-and-closing marks, like curly brackets, square brackets, or angle brackets.

public class BalancedParentheses {
    public static boolean balancedParentheses(String s) {
        int numUnclosedOpenParens = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                numUnclosedOpenParens++;
            } else if (c == ')') {
                numUnclosedOpenParens--;
            }

            if (numUnclosedOpenParens < 0) {
                return false;
            }
        }
        return numUnclosedOpenParens == 0;
    }

    public static void main(String[] args) {
        System.out.println("Balanced Parentheses:");
        System.out.println(balancedParentheses("(1)"));
        System.out.println(balancedParentheses("((1"));
        System.out.println(balancedParentheses("(1)()"));
        System.out.println(balancedParentheses(")("));
        System.out.println(balancedParentheses(""));
    }
}
