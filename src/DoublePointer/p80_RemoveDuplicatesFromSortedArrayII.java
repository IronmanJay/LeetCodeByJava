package DoublePointer;

public class p80_RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int res = removeDuplicates(nums);
        System.out.println("res = " + res);
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

}
