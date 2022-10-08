package String;

import java.util.Deque;
import java.util.LinkedList;

public class p32_LongestValidParentheses {

    public static void main(String[] args) {
        String s = ")()())";
        int res = longestValidParentheses(s);
        System.out.println("res = " + res);
    }

    public static int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int start = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        res = Math.max(res, i - stack.peek());
                    } else {
                        res = Math.max(res, i - start);
                    }
                } else {
                    start = i;
                }
            }
        }
        return res;
    }

}
