package SlidingWindow;

/**
 * @Author: IronmanJay
 * @Description: 1248.统计「优美子数组」
 * @CreateTime: 2023-06-01  17:30
 */
public class p1248_CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int res = numberOfSubarrays(nums, k);
        System.out.println("res = " + res);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        int[] index = new int[len + 2];
        int odd_count = 0;
        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 1) {
                index[++odd_count] = i;
            }
        }
        index[0] = -1;
        index[odd_count + 1] = len;
        for (int i = 1; i + k < odd_count + 2; i++) {
            res += (index[i] - index[i - 1]) * (index[i + k] - index[i + k - 1]);
        }
        return res;
    }

}
