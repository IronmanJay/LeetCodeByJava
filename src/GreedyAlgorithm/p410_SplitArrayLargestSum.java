package GreedyAlgorithm;

/**
 * @Author: IronmanJay
 * @Description: 410.分割数组的最大值
 * @CreateTime: 2022-11-12  08:52
 */
public class p410_SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        int res = splitArray(nums, m);
        System.out.println("res = " + res);
    }

    public static int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int splits = splits(nums, mid);
            if (splits > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int splits(int[] nums, int max) {
        int splits = 1;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum + nums[i] > max) {
                splits++;
                curSum = 0;
            }
            curSum += nums[i];
        }
        return splits;
    }


}
