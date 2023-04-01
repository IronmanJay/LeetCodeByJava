package SlidingWindow;

/**
 * @Author: IronmanJay
 * @Description: 643.子数组最大平均数I
 * @CreateTime: 2023-04-01  10:20
 */
public class p643_MaximumAverageSubarrayI {

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double res = findMaxAverage(nums, k);
        System.out.println("res = " + res);
    }

    public static double findMaxAverage(int[] nums, int k) {
        int tempMax = 0;
        for (int i = 0; i < k; i++) {
            tempMax += nums[i];
        }
        int sum = tempMax;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            tempMax = Math.max(tempMax, sum);
        }
        return (double) tempMax / k;
    }

}
