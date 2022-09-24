package DynamicProgramming;

public class p45_JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int res = jump(nums);
        System.out.println("res = " + res);
    }

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int bestIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            while (i > bestIndex + nums[bestIndex]) {
                bestIndex++;
            }
            dp[i] = dp[bestIndex] + 1;
        }
        return dp[nums.length - 1];
    }

}
