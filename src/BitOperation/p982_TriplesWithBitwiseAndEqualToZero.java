package BitOperation;

/**
 * @Author: IronmanJay
 * @Description: 982.按位与为零的三元组
 * @CreateTime: 2023-03-31  08:40
 */
public class p982_TriplesWithBitwiseAndEqualToZero {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        int res = countTriplets(nums);
        System.out.println("res = " + res);
    }

    public static int countTriplets(int[] nums) {
        int[] count = new int[1 << 16];
        int length = nums.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                count[nums[i] & nums[j]]++;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < (1 << 16); j++) {
                if ((j & nums[i]) == 0) {
                    res += count[j];
                }
            }
        }
        return res;
    }

}
