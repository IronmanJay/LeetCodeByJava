package Math;

/**
 * @Author: IronmanJay
 * @Description: 233.数字 1 的个数
 * @CreateTime: 2023-01-08  16:57
 */
public class p233_NumberOfDigitOne {

    public static void main(String[] args) {
        int n = 13;
        int res = countDigitOne(n);
        System.out.println("res = " + res);
    }

    public static int countDigitOne(int n) {
        long mul = 1;
        int res = 0;
        for (int k = 0; mul <= n; k++) {
            res += (n / (mul * 10)) * mul + Math.min(Math.max(n % (mul * 10) - mul + 1, 0), mul);
            mul *= 10;
        }
        return res;
    }

}
