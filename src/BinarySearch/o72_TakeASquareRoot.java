package BinarySearch;

/**
 * @Author: IronmanJay
 * @Description: 剑指 Offer II 072.求平方根
 * @CreateTime: 2022-12-26  09:53
 */
public class o72_TakeASquareRoot {

    public static void main(String[] args) {
        int x = 8;
        int res = mySqrt(x);
        System.out.println("res = " + res);
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if ((long) mid * mid <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
