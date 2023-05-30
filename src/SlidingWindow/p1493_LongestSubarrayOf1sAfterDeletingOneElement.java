package SlidingWindow;

/**
 * @Author: IronmanJay
 * @Description: 1493.删掉一个元素以后全为 1 的最长子数组
 * @CreateTime: 2023-05-30  23:46
 */
public class p1493_LongestSubarrayOf1sAfterDeletingOneElement {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1};
        int res = longestSubarray(nums);
        System.out.println("res = " + res);
    }

    public static int longestSubarray(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int zero_count = 0;
        int res = 0;
        while (right < len) {
            if (nums[right] == 0) {
                zero_count++;
            }
            while (zero_count > 1) {
                if (nums[left] == 0) {
                    zero_count--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res - 1;
    }

}
