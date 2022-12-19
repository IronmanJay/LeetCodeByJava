package DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: IronmanJay
 * @Description: 338.比特位计数
 * @CreateTime: 2022-12-19  10:29
 */
public class p338_CountingBits {

    public static void main(String[] args) {
        int n = 2;
        int[] res = countBits(n);
        System.out.println(Arrays.toString(res));
    }

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i / 2] + 1;
            }
        }
        return res;
    }

}
