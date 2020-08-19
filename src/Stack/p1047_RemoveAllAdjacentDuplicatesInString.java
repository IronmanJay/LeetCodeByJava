package Stack;

import java.util.Stack;

public class p1047_RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String S = "abbaca";
        String res = removeDuplicates(S);
        System.out.println("res = " + res);
    }

    public static String removeDuplicates(String S) {
        // 判空返回
        if (S.length() == 0 || S == null) {
            return S;
        }
        // 栈指针
        int stackIndex = 0;
        // 新建栈
        Stack<Character> stack = new Stack<>();
        // 新建结果StringBuilder
        StringBuilder res = new StringBuilder();
        // 开始遍历
        while (stackIndex < S.length()) {
            // 如果栈空或者新来的元素和栈顶元素不相同，说明这个元素可以用，直接入栈，栈指针+1
            if (stack.isEmpty() || stack.peek() != S.charAt(stackIndex)) {
                stack.push(S.charAt(stackIndex));
                stackIndex++;
                continue;
            }
            // 否则说明出现重复元素，直接将重复的元素弹出，栈指针+1
            else {
                stack.pop();
                stackIndex++;
            }
        }
        // 最后栈里面的都是不重复的，一一弹出即可
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        // 因为顺序是反的，所以反转之后返回
        return res.reverse().toString();
    }

}
