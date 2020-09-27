package DynamicProgramming;

public class I1617_ContiguousSequenceLcci {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = maxSubArray(nums);
        System.out.println("res = " + res);
    }

    public static int maxSubArray(int[] nums) {
        // 获取数组长度
        int len = nums.length;
        // 判空返回0
        if (len == 0) {
            return 0;
        }
        // 如果只有一个元素，直接返回
        if (len == 1) {
            return nums[0];
        }
        // 动态数组，存储累加数值
        int[] dp = new int[len];
        // 第一次累加就是数组的第一个值
        dp[0] = nums[0];
        // 最大值，初始值为数组第一个元素，不断更新，最后返回总和最大的连续数列和
        int max = nums[0];
        // 从第二个元素开始遍历整个数组
        for (int i = 1; i < len; i++) {
            // 动态数组对应位置存储当前位置元素和之前的和元素中较大的值
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 更新最大值
            max = Math.max(max, dp[i]);
        }
        // 返回结果
        return max;
    }

}
