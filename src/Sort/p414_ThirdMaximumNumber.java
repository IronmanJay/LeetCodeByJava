package Sort;

/**
 * @Author: IronmanJay
 * @Description: 414.第三大的数
 * @CreateTime: 2022-11-16  09:43
 */
public class p414_ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        int res = thirdMax(nums);
        System.out.println("res = " + res);
    }

    public static int thirdMax(int[] nums) {
        long a = Long.MIN_VALUE;
        long b = Long.MIN_VALUE;
        long c = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }

}
