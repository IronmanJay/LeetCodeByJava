package Stack;

import java.util.Stack;

public class p1047_RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String S = "abbaca";
        String res = removeDuplicates(S);
        System.out.println("res = " + res);
    }

    public static String removeDuplicates(String S) {
        if (S.length() == 0 || S == null) {
            return S;
        }
        int stackIndex = 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        while (stackIndex < S.length()) {
            if (stack.isEmpty() || stack.peek() != S.charAt(stackIndex)) {
                stack.push(S.charAt(stackIndex));
                stackIndex++;
                continue;
            } else {
                stack.pop();
                stackIndex++;
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

}
