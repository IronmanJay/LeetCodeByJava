package Queue;

public class o59_II_MaximumValueOfTheQueue {

    public static void main(String[] args) {
        o59_II_MaximumValueOfTheQueue maxQueue = new o59_II_MaximumValueOfTheQueue();
        maxQueue.MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        int maxValue1 = maxQueue.max_value();
        System.out.println("maxValue1 = " + maxValue1);
        int popFront = maxQueue.pop_front();
        System.out.println("popFront = " + popFront);
        int maxValue2 = maxQueue.max_value();
        System.out.println("maxValue2 = " + maxValue2);
    }

    // 队列
    private static int[] queue;
    // 头指针
    private static int front;
    // 尾指针
    private static int reat;

    // 初始化队列
    public static void MaxQueue() {
        queue = new int[10000];
    }

    // 返回当前队列最大值
    public static int max_value() {
        // 保存当前队列的最大值
        int max = -1;
        // 遍历当前队列寻找最大值
        for (int i = front; i != reat; i++) {
            max = Math.max(max, queue[i]);
        }
        // 返回最大值，队列空返回-1
        return max;
    }

    // 向队列添加数字
    public static void push_back(int value) {
        queue[reat++] = value;
    }

    // 队列头数字出队列
    public static int pop_front() {
        // 队列空返回-1
        if (front == reat) {
            return -1;
        }
        // 返回队列头数字
        return queue[front++];
    }

}
