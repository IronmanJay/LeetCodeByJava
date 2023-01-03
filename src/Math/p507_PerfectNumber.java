package Math;

/**
 * @Author: IronmanJay
 * @Description: 507.完美数
 * @CreateTime: 2023-01-03  10:41
 */
public class p507_PerfectNumber {

    public static void main(String[] args) {
        int num = 28;
        boolean res = checkPerfectNumber(num);
        System.out.println("res = " + res);
    }

    public static boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int res = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                res += i;
                if (i * i < num) {
                    res += num / i;
                }
            }
        }
        return res == num;
    }

}
