package Stack;

import java.util.Deque;
import java.util.LinkedList;

public class p402_RemoveKDigits {

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        String res = removeKdigits(num, k);
        System.out.println("res = " + res);
    }

    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<Character>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            while (!stack.isEmpty() && stack.peekLast() > digit && k > 0) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }
        StringBuilder res = new StringBuilder();
        boolean isLeadingZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();
            if (isLeadingZero && digit == '0') {
                continue;
            }
            isLeadingZero = false;
            res.append(digit);
        }
        return res.length() == 0 ? "0" : res.toString();
    }

}
