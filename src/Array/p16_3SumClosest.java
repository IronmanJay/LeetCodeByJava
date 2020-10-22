package Array;

import java.util.Arrays;

public class p16_3SumClosest {

    public static void main(String[] args) {
        int target = 1;
        int[] nums = {-1, 2, 1, -4};
        int res = threeSumClosest(nums, target);
        System.out.println("res = " + res);
    }

    public static int threeSumClosest(int[] nums, int target) {
        // 对数组进行排序
        Arrays.sort(nums);
        // 定义前三个数就是最接近的三数之和，为后续比较做准备
        int resThreeSumClosest = nums[0] + nums[1] + nums[2];
        // 遍历整个数组，i<nums.length-2是为了保证每次都可以形成三个数的和
        for (int i = 0; i < nums.length - 2; i++) {
            // 左指针为当前位置的下一个位置
            int left = i + 1;
            // 右指针为数组最后一个元素
            int right = nums.length - 1;
            // 开始遍历当前区间
            while (left < right) {
                // 当前的三数之和
                int curThreeSumClosest = nums[i] + nums[left] + nums[right];
                // 如果当前的三数之和与目标值的差值比之前定义的三数之和与目标值的差值小，更新最接近的三数之和为当前这个小的三数之和
                if (Math.abs(curThreeSumClosest - target) < Math.abs(resThreeSumClosest - target)) {
                    resThreeSumClosest = curThreeSumClosest;
                }
                // 如果当前的三数之和大于目标值，向左找更接近的三数之和
                else if (curThreeSumClosest > target) {
                    right--;
                }
                // 如果当前的三数之和小于目标值，向右找更接近的三数之和
                else if (curThreeSumClosest < target) {
                    left++;
                }
                // 如果当前的三数之和正好等于目标值，说明这就是最接近的，直接返回即可
                else {
                    return target;
                }
            }
        }
        // 返回结果
        return resThreeSumClosest;
    }

}
