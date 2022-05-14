package Array;

public class p27_RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int res = removeElement(nums, 3);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length, index = 0;
        if (len == 0 || nums == null) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}
