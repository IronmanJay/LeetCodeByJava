package GreedyAlgorithm;

/**
 * @Author: IronmanJay
 * @Description: 334.递增的三元子序列
 * @CreateTime: 2023-03-07  11:00
 */
public class p334_IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        boolean res = increasingTriplet(nums);
        System.out.println("res = " + res);
    }

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

}
