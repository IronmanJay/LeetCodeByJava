package DynamicProgramming;

/**
 * @Author: IronmanJay
 * @Description: 152.乘积最大子数组
 * @CreateTime: 2022-12-23  10:18
 */
public class p152_MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int res = maxProduct(nums);
        System.out.println("res = " + res);
    }

    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int tempMax = 1;
        int tempMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = tempMax;
                tempMax = tempMin;
                tempMin = temp;
            }
            tempMax = Math.max(tempMax * nums[i], nums[i]);
            tempMin = Math.min(tempMin * nums[i], nums[i]);
            res = Math.max(res, tempMax);
        }
        return res;
    }

}
