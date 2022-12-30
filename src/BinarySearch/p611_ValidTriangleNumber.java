package BinarySearch;

import java.util.Arrays;

/**
 * @Author: IronmanJay
 * @Description: 611.有效三角形的个数
 * @CreateTime: 2022-12-30  10:16
 */
public class p611_ValidTriangleNumber {

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        int res = triangleNumber(nums);
        System.out.println("res = " + res);
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int left = j + 1;
                int right = len - 1;
                int k = j;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] >= nums[i] + nums[j]) {
                        right = mid - 1;
                    } else {
                        k = mid;
                        left = mid + 1;
                    }
                }
                res += k - j;
            }
        }
        return res;
    }

}
