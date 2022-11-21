package Array;

/**
 * @Author: IronmanJay
 * @Description: 136.只出现一次的数字
 * @CreateTime: 2022-11-21  09:19
 */
public class p136_SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int res = singleNumber(nums);
        System.out.println("res = " + res);
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

}
