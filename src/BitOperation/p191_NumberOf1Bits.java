package BitOperation;

/**
 * @Author: IronmanJay
 * @Description: 191.位1的个数
 * @CreateTime: 2023-03-23  10:14
 */
public class p191_NumberOf1Bits {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        int res = hammingWeight(n);
        System.out.println("res = " + res);
    }

    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

}
