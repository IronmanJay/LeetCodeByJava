package DynamicProgramming;

public class p279_PerfectSquares {

    public static void main(String[] args) {
        int n = 12;
        int res = numSquares(n);
        System.out.println("res = " + res);
    }

    public static int numSquares(int n) {
        // 动态数组
        int[] dp = new int[n + 1];
        // 遍历数组
        for (int i = 1; i <= n; i++) {
            // 最坏的情况是1+1+1+……+1
            dp[i] = i;
            // 找每一个状态的最优解
            for (int j = 0; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        // 返回结果
        return dp[n];
    }

}
