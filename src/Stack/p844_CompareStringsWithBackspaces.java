package Stack;

import java.util.Stack;

public class p844_CompareStringsWithBackspaces {

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        boolean res = backspaceCompare(s, t);
        System.out.println("res = " + res);
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack stackS = new Stack();
        Stack stackT = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stackS.push(s.charAt(i));
            } else {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                } else {
                    continue;
                }
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                stackT.push(t.charAt(i));
            } else {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                } else {
                    continue;
                }
            }
        }
        if (stackS.size() != stackT.size()) {
            return false;
        } else {
            while (!stackS.isEmpty()) {
                if (stackS.pop() != stackT.pop()) {
                    return false;
                }
            }
        }
        return true;
    }

}
