package GreedyAlgorithm;

public class p55_JumpGame {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean res = canJump(nums);
        System.out.println("res = " + res);
    }

    public static boolean canJump(int[] nums) {
        // 获取数组长度
        int len = nums.length;
        // 表示每个位置可以跳的最远距离
        int maxLen = nums[0];
        // 开始遍历
        for (int i = 1; i < len; i++) {
            // 如果当前位置在前一个位置所能跳的最远距离范围内，看当前位置能跳的最远距离是否大于前一个位置所能跳的最远距离
            if (i <= maxLen) {
                // 如果能跳的更远，更新可以跳的最远距离
                maxLen = Math.max(maxLen, nums[i] + i);
            }
        }
        // 如果最终的距离超过最后一个位置，即可以到达最后一个位置
        return maxLen >= len - 1;
    }

}
