package DynamicProgramming;

public class p64_MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        int res = minPathSum(grid);
        System.out.println("res = " + res);
    }

    public static int minPathSum(int[][] grid) {
        // 获取行数
        int row = grid.length;
        // 获取列数
        int col = grid[0].length;
        // 如果是空矩阵返回0
        if (row == 0 || col == 0) {
            return 0;
        }
        // 如果只有一个数直接返回
        if (row == 1 && col == 1) {
            return grid[0][0];
        }
        // 遍历整个二维数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 起点，直接跳过，因为没有走向起点的路经
                if (i == 0 && j == 0) {
                    continue;
                }
                // 第一行，只能向右走
                else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }
                // 第一列，只能向下走
                else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }
                // 不是第一行也不是第一列，从向下走和向右走中选取小的路经（状态）
                else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        // 终点最后就是最小路径和
        return grid[row - 1][col - 1];
    }

}
