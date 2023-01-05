package Math;

/**
 * @Author: IronmanJay
 * @Description: 50.Pow(x, n)
 * @CreateTime: 2023-01-05  10:59
 */
public class p50_PowXN {

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        double res = myPow(x, n);
        System.out.println("res = " + res);
    }

    public static double myPow(double x, int n) {
        if (x == 0.0) {
            return x;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

}
