package Queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class p239_SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (nums == null || len < 2) {
            return nums;
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[queue.peek()];
            }
        }
        return res;
    }
}
