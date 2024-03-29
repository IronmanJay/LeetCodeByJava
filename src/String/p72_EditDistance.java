package String;

/**
 * @Author: IronmanJay
 * @Description: 72.编辑距离
 * @CreateTime: 2022-12-03  10:27
 */
public class p72_EditDistance {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int res = minDistance(word1, word2);
        System.out.println("res = " + res);
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

}
