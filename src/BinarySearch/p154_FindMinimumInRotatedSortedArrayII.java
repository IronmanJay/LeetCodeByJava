package BinarySearch;

/**
 * @Author: IronmanJay
 * @Description: 154.寻找旋转排序数组中的最小值 II
 * @CreateTime: 2022-12-31  01:05
 */
public class p154_FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        int res = findMin(nums);
        System.out.println("res = " + res);
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }

}
