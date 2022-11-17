package Sort;

import java.util.Arrays;

/**
 * @Author: IronmanJay
 * @Description: 462.最小操作次数使数组元素相等 II
 * @CreateTime: 2022-11-17  09:29
 */
public class p462_MinimumMovesToEqualArrayElementsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int res = minMoves2(nums);
        System.out.println("res = " + res);
    }

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int mid = nums[len / 2];
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.abs(nums[i] - mid);
        }
        return res;
    }

}
