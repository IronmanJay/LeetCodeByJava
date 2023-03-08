package GreedyAlgorithm;

/**
 * @Author: IronmanJay
 * @Description: 376.摆动序列
 * @CreateTime: 2023-03-08  10:40
 */
public class p376_WiggleSubsequence {

    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        int res = wiggleMaxLength(nums);
        System.out.println("res = " + res);
    }

    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int preDiff = nums[1] - nums[0];
        int res = preDiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((preDiff >= 0 && diff < 0) || (preDiff <= 0 && diff > 0)) {
                res++;
                preDiff = diff;
            }
        }
        return res;
    }

}
