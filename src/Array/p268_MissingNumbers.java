package Array;

public class p268_MissingNumbers {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int res = missingNumber(nums);
        System.out.println("res = " + res);
    }

    public static int missingNumber(int[] nums) {
        int[] map = new int[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            map[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]] = 1;
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (map[i] == 0) {
                return i;
            }
        }
        return 0;
    }

}
