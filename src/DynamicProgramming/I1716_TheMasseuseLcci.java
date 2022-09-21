package DynamicProgramming;

public class I1716_TheMasseuseLcci {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int res = massage(nums);
        System.out.println("res = " + res);
    }

    public static int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

}
