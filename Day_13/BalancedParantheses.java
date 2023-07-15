import java.util.Stack;

public class BalancedParantheses {
    public static boolean isValidParenthesis(String expression) {
        Stack<Character> stk = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stk.push(ch);
            } else {
                if (stk.empty() ||
                        (ch == '}' && stk.peek() != '{') ||
                        (ch == ']' && stk.peek() != '[') ||
                        (ch == ']' && stk.peek() != '[')) {
                    return false;
                }
                stk.pop();
            }
        }
        if (!stk.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        if (isValidParenthesis("{}()")) {
            System.out.println("valid parantheses");
        } else {
            System.out.println("invalid parantheses");
        }
    }
}
