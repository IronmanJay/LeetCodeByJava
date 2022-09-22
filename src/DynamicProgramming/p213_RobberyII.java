package DynamicProgramming;

public class p213_RobberyII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int res = rob(nums);
        System.out.println("res = " + res);
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(getRes(nums, 0, len - 2), getRes(nums, 1, len - 1));
    }


    public static int getRes(int[] nums, int begin, int end) {
        int[] dp = new int[nums.length];
        dp[begin] = nums[begin];
        dp[begin + 1] = Math.max(nums[begin], nums[begin + 1]);
        for (int i = begin + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }

}
