package Stack;

import java.util.Stack;

public class p232_ImplementQueueUsingStacks {

    public static void main(String[] args) {
        p232_ImplementQueueUsingStacks p232_implementQueueUsingStacks = new p232_ImplementQueueUsingStacks();
        p232_implementQueueUsingStacks.push(1);
        p232_implementQueueUsingStacks.push(2);
        int peek = p232_implementQueueUsingStacks.peek();
        int pop = p232_implementQueueUsingStacks.pop();
        boolean empty = p232_implementQueueUsingStacks.empty();
        System.out.println(peek + "," + pop + "," + empty);

    }

    // 主栈
    public Stack<Integer> stackMain;
    // 辅助栈
    public Stack<Integer> stackHelp;

    // 初始化两个栈
    public p232_ImplementQueueUsingStacks() {
        stackMain = new Stack<>();
        stackHelp = new Stack<>();
    }

    // 向“队列”中加入元素
    public void push(int x) {
        stackMain.push(x);
    }

    // 弹出“队首”元素
    public int pop() {
        /*
          如果辅助栈为空，就将主栈的元素pop进辅助栈，那么辅助栈现在的结构就和队列一样了
          如果辅助栈不为空，说明已经将主栈的元素放入辅助栈了，那么辅助栈现在的结构就和队列一样了
          不管那种情况，辅助栈的结构都和队列一样，都可以弹出辅助栈栈首的元素，这就相当于“队首”元素
        */
        if (stackHelp.isEmpty()) {
            while (!stackMain.isEmpty()) {
                stackHelp.push(stackMain.pop());
            }
        }
        return stackHelp.pop();
    }

    // 取出“队首”元素
    public int peek() {
       /*
          如果辅助栈为空，就将主栈的元素pop进辅助栈，那么辅助栈现在的结构就和队列一样了
          如果辅助栈不为空，说明已经将主栈的元素放入辅助栈了，那么辅助栈现在的结构就和队列一样了
          不管那种情况，辅助栈的结构都和队列一样，都可以取出辅助栈栈首的元素，这就相当于“队首”元素
        */
        if (stackHelp.isEmpty()) {
            while (!stackMain.isEmpty()) {
                stackHelp.push(stackMain.pop());
            }
        }
        return stackHelp.peek();
    }

    // 判断“队列”是否为空
    public boolean empty() {
        // 只有当主栈和辅助栈都为空的时候，才说明“队列”已经空了，一个元素都没有了
        return stackMain.isEmpty() && stackHelp.isEmpty();
    }

}
