package DynamicProgramming;

/**
 * @Author: IronmanJay
 * @Description: 面试题 08.01.三步问题
 * @CreateTime: 2022-12-21  10:04
 */
public class I0801_ThreeStepsProblemLcci {

    public static void main(String[] args) {
        int n = 3;
        int res = waysToStep(n);
        System.out.println("res = " + res);
    }

    public static int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3]) % 1000000007;
        }
        return dp[n];
    }

}

