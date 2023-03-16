package DoublePointer;

import java.util.Arrays;

/**
 * @Author: IronmanJay
 * @Description: 283.移动零
 * @CreateTime: 2023-03-16  10:40
 */
public class p283_MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

}
