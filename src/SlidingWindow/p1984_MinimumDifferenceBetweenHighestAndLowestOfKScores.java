package SlidingWindow;

import java.util.Arrays;

/**
 * @Author: IronmanJay
 * @Description: 1984.学生分数的最小差值
 * @CreateTime: 2023-04-02  09:09
 */
public class p1984_MinimumDifferenceBetweenHighestAndLowestOfKScores {

    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        int res = minimumDifference(nums, k);
        System.out.println("res = " + res);
    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = nums[k - 1] - nums[0];
        for (int i = k; i < nums.length; i++) {
            res = Math.min(res, nums[i] - nums[i - k + 1]);
        }
        return res;
    }

}
