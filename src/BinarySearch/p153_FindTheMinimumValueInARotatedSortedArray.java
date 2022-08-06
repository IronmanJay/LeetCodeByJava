package BinarySearch;

public class p153_FindTheMinimumValueInARotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int res = findMin(nums);
        System.out.println("res = " + res);
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

}
