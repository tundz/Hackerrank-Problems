import java.util.Stack;

public class bracketbal {
    public static boolean isBalanced(String expression) {
        Stack<Character> stk = new Stack<Character>();
        
        for (int i = 0; i < expression.length(); i++) {
            char x = expression.charAt(i);
            if (x == '{' || x == '[' || x == '(')
                stk.push(x);
            
            else if (x == '}' || x == ']' || x == ')') {
                if(stk.isEmpty())
                    return false;
                char left = stk.pop();
                if (x == '}' && left != '{')
                    return false;
                if (x == ')' && left != '(')
                    return false;
                if (x == ']' && left != '[')
                    return false;
            }
                
        }
        if(!stk.isEmpty())
            return false;
        
        return true;
    }
}
