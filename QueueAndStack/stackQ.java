package QueueAndStack;

import java.util.Stack;

public class stackQ {
    public static void main(String[] args) {
        String valid = "{[{}{}]}[()]";
        String invalid = "{()}[)";

        System.out.println(Question5(valid));
        System.out.println(Question5(invalid));
    }

    public static boolean isSame(char c, char next) {
        if (c == '{' && next == '}') return true;
        if (c == '[' && next == ']') return true;
        if (c == '(' && next == ')') return true;
        return false;
    }

    public static boolean Question5(String s) {
        Stack<Character> helper = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '{' || current == '[' || current == '(') {
                helper.push(current);
            }
            else {
                if (helper.empty() ){
                    return false;
                }
                char top = helper.pop();
                if (!isSame(top,current)) return false;
            }
        }
        return helper.empty(); // Return true if helper stack is empty (balanced brackets)
    }
}
