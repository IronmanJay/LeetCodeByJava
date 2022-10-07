package String;

import java.util.Stack;

public class p151_ReverseWordsInAString {

    public static void main(String[] args) {
        String s = "the sky is blue";
        String res = reverseWords(s);
        System.out.println("res = " + res);
    }

    public static String reverseWords(String s) {
        s = s.trim();
        Stack<String> stack = new Stack();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == ' ' && sb.length() > 0) {
                stack.push(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        stack.push(sb.toString());
        sb.delete(0, sb.length());
        while (!stack.empty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
