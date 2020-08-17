package Stack;

import java.util.Stack;

public class I0302_MinStackLcci {

    public static void main(String[] args) {
        I0302_MinStackLcci minStack = new I0302_MinStackLcci();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min1 = minStack.getMin();
        minStack.pop();
        int top = minStack.top();
        int min2 = minStack.getMin();
        System.out.println(min1 + "," + top + "," + min2);
    }

    int min = Integer.MAX_VALUE; // 用于比较得到最小值
    Stack<Integer> stackMain; // 主栈，用于存放值
    Stack<Integer> stackHelp; // 辅助栈，用于存放每一次入栈之后的当前栈最小值

    // 初始化两个栈
    public I0302_MinStackLcci() {
        stackMain = new Stack<>();
        stackHelp = new Stack<>();
    }

    // 数据入栈
    public void push(int x) {
        // 首先获取当前元素入栈之后的栈的最小值
        min = Math.min(min, x);
        // 将元素入主栈
        stackMain.push(x);
        // 将当前栈的最小值入辅助栈
        stackHelp.push(min);
    }

    // 弹出栈顶元素
    public void pop() {
        // 主栈弹出栈顶元素
        stackMain.pop();
        // 因为主栈弹出了一个元素，所以辅助栈对应的弹出的栈的最小值也弹出，回到上一个存放最小值的状态
        stackHelp.pop();
        // 如果辅助栈空了，说明没有最小值了，重新赋值得到最小值
        if (stackHelp.isEmpty()) {
            min = Integer.MAX_VALUE;
        }
        // 如果没空，因为辅助栈对应每一个栈状态的最小值，所以将min重新赋值为弹出栈顶元素之后当前栈对应的最小值，为了getMin()方法做准备
        else {
            min = stackHelp.peek();
        }
    }

    // 获取栈顶元素
    public int top() {
        return stackMain.peek();
    }

    // 得到当前栈的最小值
    public int getMin() {
        return min;
    }

}
