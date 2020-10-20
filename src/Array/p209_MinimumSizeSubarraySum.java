package Array;

public class p209_MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int res = minSubArrayLen(s, nums);
        System.out.println("res = " + res);
    }

    public static int minSubArrayLen(int s, int[] nums) {
        // 判空返回
        if (nums.length == 0) {
            return 0;
        }
        // 头指针
        int start = 0;
        // 尾指针
        int end = 0;
        // 存储当前窗口（区间）的数字和
        int sum = 0;
        // 最小连续子数组的长度
        int len = Integer.MAX_VALUE;
        // 遍历数组
        while (end < nums.length) {
            // 累加求值，找到大于目标值的区间（窗口）
            sum += nums[end];
            // 找到一个窗口（区间）大于目标值
            while (sum >= s) {
                // 更新最小连续子数组的长度
                len = Math.min(len, (end - start + 1));
                // 继续在这个窗口（区间）缩小当前窗口（区间）继续寻找大于等于目标值的小窗口（区间），如果有的话，更新头指针和最小连续子数组的长度
                sum -= nums[start];
                start++;

            }
            // 当前窗口（区间）的数字和不大于等于目标值，向右滑动继续查找
            end++;
        }
        // 返回结果
        return len == Integer.MAX_VALUE ? 0 : len;
    }

}
