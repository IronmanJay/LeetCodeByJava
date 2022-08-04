package BinarySearch;

import java.util.Arrays;

public class p34_FindTheFirstAndLastPositionOfAnElementInASortedArray {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res = searchRange(nums, 8);
        System.out.println("res " + Arrays.toString(res));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        res[0] = left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        res[1] = right;
        return res;
    }

}
