package DynamicProgramming;

/**
 * @Author: IronmanJay
 * @Description: 264.丑数 II
 * @CreateTime: 2022-12-22  09:35
 */
public class p264_UglyNumberII {

    public static void main(String[] args) {
        int n = 10;
        int res = nthUglyNumber(n);
        System.out.println("res = " + res);
    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n];
    }

}
