package BitOperation;

/**
 * @Author: IronmanJay
 * @Description: 231.2的幂
 * @CreateTime: 2023-03-22  10:26
 */
public class p231_PowerOfTwo {

    public static void main(String[] args) {
        int n = 1;
        boolean res = isPowerOfTwo(n);
        System.out.println("res = " + res);
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
