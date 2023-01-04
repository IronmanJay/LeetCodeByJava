package Math;

/**
 * @Author: IronmanJay
 * @Description: 258.各位相加
 * @CreateTime: 2023-01-04  10:51
 */
public class p258_AddDigits {

    public static void main(String[] args) {
        int num = 38;
        int res = addDigits(num);
        System.out.println("res = " + res);
    }

    public static int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

}
