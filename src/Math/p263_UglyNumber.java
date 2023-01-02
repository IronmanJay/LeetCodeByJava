package Math;

/**
 * @Author: IronmanJay
 * @Description: 263.丑数
 * @CreateTime: 2023-01-02  10:45
 */
public class p263_UglyNumber {

    public static void main(String[] args) {
        int n = 6;
        boolean res = isUgly(n);
        System.out.println("res = " + res);
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

}
