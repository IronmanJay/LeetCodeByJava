package Sort;

import java.util.Arrays;

/**
 * @Author: IronmanJay
 * @Description: 905.按奇偶排序数组
 * @CreateTime: 2022-11-14  09:04
 */
public class p905_SortArrayByParity {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        int[] res = sortArrayByParity(nums);
        System.out.println("res = " + Arrays.toString(nums));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 != 0) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

}
