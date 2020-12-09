package String;

import java.util.Stack;

public class p20_ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean res = isValid(s);
        System.out.println("res = " + res);
    }

    public static boolean isValid(String s) {
        // 栈存储左括号对应的右括号
        Stack<Character> stack = new Stack<>();
        // 遍历字符串
        for (char c : s.toCharArray()) {
            // 遇到左括号就把对应的右括号入栈
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            }
            // 如果遇到右括号时栈空或者不匹配返回false，注意：要先判断是否为空，如果先判断是否相等已经弹出说明栈有可能为空就会返回false，出错了
            else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        // 最后如果栈为空说明全部匹配成功
        return stack.isEmpty();
    }

}
