package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class o10_I_FibonacciSequence {

    public static void main(String[] args) {
        int n = 0;
        int res = fib(n);
        System.out.println("res = " + res);
    }

    public static int fib(int n) {
        // 小于等于1的数字的斐波那契数列和就是自身
        if (n <= 1) {
            return n;
        }
        // 队列存放前n项的和
        Deque<Integer> queue = new LinkedList<>();
        // 先将前两项入队列
        queue.offer(1);
        queue.offer(1);
        // 从第三项开始进行斐波那契数列的计算
        int count = 3;
        // 存放每两项的和
        int addNum = 0;
        // 存放每两项取模后的和
        int newAddNum = 0;
        // 从第三项开始遍历
        while (count <= n) {
            // 一个poll()一个peek()的意义在于取两个数相加
            addNum = queue.poll() + queue.peek();
            // 按题意要求和的结果等于1000000008返回1
            if (addNum == 1000000008) {
                return 1;
            }
            // 否则对和的结果取模
            else {
                newAddNum = addNum % 1000000007;
            }
            // 将取模后和的结果入队列，队列里面总是存放前n-1项的和和前n项的和
            queue.offer(newAddNum);
            // 项数+1
            count++;
        }
        // 队列中最后一个元素就是前n项的和
        return queue.getLast();
    }

}
