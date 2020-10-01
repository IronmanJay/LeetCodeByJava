package DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class p120_Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();
        triangle.add(new LinkedList<>(Arrays.asList(2)));
        triangle.add(new LinkedList<>(Arrays.asList(3, 4)));
        triangle.add(new LinkedList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new LinkedList<>(Arrays.asList(4, 1, 8, 3)));
        int res = minimumTotal(triangle);
        System.out.println("res = " + res);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        // 获取三角形行数
        int row = triangle.size();
        // 特判
        if (row == 0 || triangle == null) {
            return 0;
        }
        // 动态数组，行和列都+1的目的是为了第一次初始化第一行
        int[][] dp = new int[row + 1][row + 1];
        // 自底向上开始规划
        for (int i = row - 1; i >= 0; i--) {
            // 从底向上取出每一列
            List<Integer> curList = triangle.get(i);
            // 第一次需要初始化最后一行，以后不需要。另外，第几行就有几个数。找出每一行符合条件最小的值
            for (int j = 0; j < curList.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + curList.get(j);
            }
        }
        // 返回结果
        return dp[0][0];
    }

}
