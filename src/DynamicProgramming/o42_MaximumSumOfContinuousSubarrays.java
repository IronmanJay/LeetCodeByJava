package DynamicProgramming;

/**
 * @Author: IronmanJay
 * @Description: 剑指 Offer 42.连续子数组的最大和
 * @CreateTime: 2022-12-20  11:25
 */
public class o42_MaximumSumOfContinuousSubarrays {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = maxSubArray(nums);
        System.out.println("res = " + res);
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
